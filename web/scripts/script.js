const state = {
    topics: [],
    subtopics: [],
    topic_id: 0,
    search_keyword: "",
    pageNumber: 1,
    searchObject: {},
    pages: "",
    path: "StackDocMvn_Web_exploded",
    pass: "",
    isAdmin: false,
    subtopic_name: "",
    description: "",
    body_html: "",
    examplesList: []
};

const request = async () => {
    const topics = await fetch(`http://localhost:8080/${state.path}/api/topics`);
    const subtopics = await fetch(`http://localhost:8080/${state.path}/api/subtopics`);
    const searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
        {
            method: "POST",
            body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
    state.topics = await topics.json();
    state.subtopics = await subtopics.json();
    state.searchObject = await searchObject.json();
    state.pages = state.searchObject.pages;
};

const changeState = (e, name) => state[name] = e.target.value;

window.onload = async () => {
    await request();
    templateGenerator(false, Home);
    contentGenerator(true, state.isAdmin);
    paginationLogic("1");
    document.querySelector('.adminpage_logout').style.display = "none";
    document.querySelector('.admin_create').style.display = "none";
    setAttribute();
};

const onChange = async () => {
    state.pageNumber = 1;
    const response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
            method: "POST",
            body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
    const searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
        {
            method: "POST",
            body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
    state.subtopics = await response.json();
    state.searchObject = await searchObject.json();
    state.pages = state.searchObject.pages;
    /*
     Rebuild full page
     const app = document.querySelector("#app");
     app.innerHTML = "";
     converter(Home, app);
    */
    // Rebuild only content
    // ************************************************
    // set content to empty
    document.querySelector('.select_topic').innerHTML = "";
    document.querySelector('.subtopics').innerHTML = "";
    const option = document.createElement("option");
    option.value = 0;
    parseFloat(state.topic_id) === 0 && option.setAttribute("selected", "selected");
    document.querySelector('.select_topic').appendChild(option);
    // *************************************************
    contentGenerator(true, state.isAdmin); ///
    paginationLogic("1");
    setAttribute();
    if (!state.pages) {
        document.querySelector('.subtopics').innerHTML = "<p style='margin: auto; font-size: 40px;font-weight: 700;'>No" +
            " results found!</p>";
        document.querySelector('.page_number').textContent = "";
    }
};

const onClick = async subtopic_id => {
    const response = await fetch(`http://localhost:8080/${state.path}/api/subtopics`,
        {
            method: "POST",
            body: `subtopicid=${subtopic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });

    const json = await response.json();

    templateGenerator(true, Description);

    document.querySelector('.subtopic_title').textContent = json.description.sub_topic;
    document.querySelector('.content').innerHTML += json.description.description;
    document.querySelector('.content').innerHTML += json.description.body_HTML;
    document.querySelectorAll('img').forEach(img => {
        const div = document.createElement("div");
        div.className = "image";
        img.parentNode.appendChild(div).appendChild(img);
    });
};

const clickPrevious = async () => {
    state.pageNumber--;
    const response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
            method: "POST",
            body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
    state.subtopics = await response.json();
    document.querySelector('.subtopics').innerHTML = "";
    contentGenerator(false, state.isAdmin);
    paginationLogic("2");
    changePageNumber();
};

const clickNext = async () => {
    state.pageNumber++;
    const response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
            method: "POST",
            body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
    state.subtopics = await response.json();
    document.querySelector('.subtopics').innerHTML = "";
    contentGenerator(false, state.isAdmin);
    paginationLogic("3");
    changePageNumber();
};

const clickBack = () => {
    templateGenerator(true, Home);
    contentGenerator(true, state.isAdmin);
    paginationLogic("4");
    state.isAdmin ?
        ((document.querySelector('.adminpage_logout').style.display = "inline-block")
            &&
            (document.querySelector('.adminpage_login').style.display = "none")
            &&
            (document.querySelector('.admin_create').style.display = "inline-block")
        )
        :
        ((document.querySelector('.adminpage_logout').style.display = "none")
            &&
            (document.querySelector('.adminpage_login').style.display = "inline-block")
            &&
            (document.querySelector('.admin_create').style.display = "none")
        );
    setAttribute();
};

const setAttribute = () => {
    document.querySelector('.search').setAttribute("value", state.search_keyword);
    document.querySelector('.select_topic').setAttribute("value", state.topic_id);
    document.querySelector('.page_number').textContent = state.pageNumber;
};

const changePageNumber = () => document.querySelector('.page_number').textContent = state.pageNumber;

const templateGenerator = (requirePageRebuild, page) => {
    const app = document.querySelector("#app");
    requirePageRebuild && (app.innerHTML = "");
    converter(page, app);
};

const contentGenerator = (requireTopics, isAdmin) => {
    requireTopics && (
        state.topics.forEach(topic => {
            const option = document.createElement("option");
            option.textContent = topic.topic;
            option.value = topic.id;
            parseFloat(state.topic_id) === topic.id && option.setAttribute("selected", "selected");
            document.querySelector('.select_topic').appendChild(option);
        })
    );
    state.subtopics.forEach((subtopic, i) => {
        const div = document.createElement("div");
        div.className = "subtopic";
        div.setAttribute("onclick", `onClick(${subtopic.id})`);
        isAdmin && ((div.style.width = "92%"));
        document.querySelector('.subtopics').appendChild(div);
        const topic_name = document.createElement("span");
        topic_name.className = "topic_name";
        topic_name.textContent = subtopic.topicId;
        const subtopic_name = document.createElement("span");
        subtopic_name.className = "subtopic_name";
        subtopic_name.textContent = subtopic.subTopic;
        document.querySelectorAll(".subtopic")[i].appendChild(topic_name);
        document.querySelectorAll(".subtopic")[i].appendChild(subtopic_name);
        if (isAdmin) {
            const subtopic_delete = document.createElement("span");
            subtopic_delete.className = "subtopic_delete";
            subtopic_delete.innerHTML = "<i class='fas fa-times'></i>";

            const subtopic_update = document.createElement("span");
            subtopic_update.className = "subtopic_update";
            subtopic_update.innerHTML = "<i class='fas fa-edit'></i>";

            document.querySelector(".subtopics").appendChild(subtopic_delete);
            document.querySelector(".subtopics").appendChild(subtopic_update);

            document.querySelectorAll('.fa-times')[i]
                .setAttribute("onclick", `clickShowDelete(${subtopic.id})`);
            document.querySelectorAll('.fa-edit')[i]
                .setAttribute("onclick", `clickShowUpdateForm(${subtopic.id})`);
        }
    });
};

const paginationLogic = order => {
    const previous = document.querySelector('.previous'), next = document.querySelector('.next');
    order === "1" && ((previous.style.visibility = "hidden") &&
        (state.pageNumber < state.pages ? next.style.visibility = "visible" : next.style.visibility = "hidden"));
    order === "2" && ((next.style.visibility = "visible") &&
        (state.pageNumber > 1 ? previous.style.visibility = "visible" : previous.style.visibility = "hidden"));
    order === "3" && ((previous.style.visibility = "visible") &&
        (state.pageNumber < state.pages ? next.style.visibility = "visible" : next.style.visibility = "hidden"));
    order === "4" && ((state.pageNumber < state.pages ? next.style.visibility = "visible" : next.style.visibility = "hidden") &&
        (state.pageNumber > 1 ? previous.style.visibility = "visible" : previous.style.visibility = "hidden"));
};

const clickShowLogin = () => {
    overlayLogic(true, "clickHide('.login_popup')");
    document.querySelector('.login_popup').style.top = "50%";
};
const clickShowLogout = () => {
    overlayLogic(true, "clickHide('.logout_popup')");
    document.querySelector('.logout_popup').style.top = "50%";
};
const clickShowDelete = subtopic_id => {
    overlayLogic(true, "clickHide('.delete_popup')");
    document.querySelector('.delete_popup').style.top = "50%";
    document.querySelector('.delete_button').setAttribute("onclick", `clickDelete(${subtopic_id});clickHide('.delete_popup')`);
};

const clickShowCreateForm = () => {
    overlayLogic(true, "clickHide('.create_form_popup')");
    state.topics.forEach(topic => {
        const option = document.createElement("option");
        option.textContent = topic.topic;
        option.value = topic.id;
        document.querySelector('.select').appendChild(option);
    });

    const event = new Event("change");

    document.querySelector('.select').dispatchEvent(event);
    document.querySelector('.create_form_popup').style.top = "50%";
};

const clickShowUpdateForm = async subtopic_id => {
    overlayLogic(true, "clickHide('.update_form_popup')");
    const response = await fetch(`http://localhost:8080/${state.path}/api/subtopics`,
        {
            method: "POST",
            body: `subtopicid=${subtopic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });

    const json = await response.json();
    state.description = json.description.description;
    state.body_html = json.description.body_HTML;
    state.examplesObject = json.exampleList;
    if (document.querySelectorAll("textarea").length > 3) {
        for (let i = document.querySelectorAll("textarea").length - 1; i > 2; i--) {
            document.querySelectorAll("textarea")[i].parentNode.removeChild(document.querySelectorAll("textarea")[i])
        }
    }

    state.examplesList = [];

    json.exampleList.forEach((element, i) => {
        let textarea = document.createElement("textarea");
        textarea.value = element.body_html;
        textarea.onkeyup = event => {
            state.examplesList.forEach(element => {
                if (element.id === state.examplesList[i].id) {
                    element.body_html = event.target.value
                    console.log(element.id)
                    console.log(element.body_html)
                }
            })
        }
        state.examplesList.push({
            id: element.id,
            body_html: element.body_html
        });
        document.querySelector('.update_form_popup').append(textarea);
    });

    document.querySelectorAll('.description_html_textarea')[1].value = state.description;
    document.querySelector('.body_html_textarea').value = state.body_html;

    document.querySelector('.update_form_popup').style.top = "50%";
    document.querySelector('.update_subtopic_button')
        .setAttribute("onclick", `clickUpdate(${subtopic_id});clickHide('.update_form_popup')`);
};

const clickHide = type => {
    overlayLogic(false);
    document.querySelector(type).style.top = "-50%";
};

const overlayLogic = (active, type) => {
    active
        ?
        ((document.querySelector('.overlay').style.display = "block")
            &&
            (document.querySelector('.overlay').style.opacity = "1")
            &&
            (document.querySelector('.overlay').setAttribute("onclick", type)
            )
        )
        :
        ((document.querySelector('.overlay').style.display = "none")
            &&
            (document.querySelector('.overlay').style.opacity = "0"))
};

const clickLogin = async () => {

    try {

        const response = await fetch(`http://localhost:8080/${state.path}/admin`,
            {
                method: "POST",
                body: `pass=${state.pass}`,
                headers:
                    {
                        "Content-Type": "application/x-www-form-urlencoded"
                    }
            });

        if (response.status === 200) {
            state.isAdmin = true;
            document.querySelector('.login_popup').style.top = "-50%";
            overlayLogic(false);
            setTimeout(() => {
                document.querySelector('.subtopics').innerHTML = "";
                contentGenerator(false, state.isAdmin);
                document.querySelector('.adminpage_logout').style.display = "inline-block";
                document.querySelector('.admin_create').style.display = "inline-block";
                document.querySelector('.adminpage_login').style.display = "none";
            }, 500);
        } else {
            throw new Error("wtf");
        }
    } catch (err) {
        console.log(err.response.data);
    }
};

const clickLogout = async () => {
    state.isAdmin = false;
    document.querySelector('.logout_popup').style.top = "-50%";
    overlayLogic(false);
    setTimeout(() => {
        document.querySelector('.subtopics').innerHTML = "";
        contentGenerator(false, state.isAdmin);
        document.querySelector('.adminpage_logout').style.display = "none";
        document.querySelector('.admin_create').style.display = "none";
        document.querySelector('.adminpage_login').style.display = "inline-block";
    }, 500);
};

const clickDelete = async subtopic_id => {
    const response = await fetch(`http://localhost:8080/${state.path}/admin/delete`,
        {
            method: "POST",
            body: `subtopicid=${subtopic_id}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
    state.subtopics = await response.json();
    document.querySelector('.subtopics').innerHTML = "";
    contentGenerator(false, state.isAdmin);
};

const clickCreate = async () => {
    const response = await fetch(`http://localhost:8080/${state.path}/admin/create`,
        {
            method: "POST",
            body: `topics=${state.topic_id}&subtopicname=${state.subtopic_name}&descriptionHTML=${state.description}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
};

const clickUpdate = async subtopic_id => {

    const examplesList = JSON.stringify(state.examplesList);

    const response = await fetch(`http://localhost:8080/${state.path}/admin/update`,
        {
            method: "POST",
            body: `subtopicid=${subtopic_id}&descriptionHTML=${state.description}&examplesList=${examplesList}`,
            headers:
                {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
        });
};















