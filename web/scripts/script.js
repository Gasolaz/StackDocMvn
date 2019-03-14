const state = {
  topics: [],
  subtopics: [],
  topic_id: 0,
  search_keyword: "",
  pageNumber: 1,
  searchObject: {},
  pages: "",
  path: "com_Saras_Web_exploded",
  pass: "",
  isAdmin: false,
  subtopic_name: "",
  description: "",
  body_html: "",
  examplesList: []
};

const request = async () => {
  try {

    var topics = await fetch(`http://localhost:8080/${state.path}/api/topics`);
    var subtopics = await fetch(`http://localhost:8080/${state.path}/api/subtopics`);
    var searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
  } catch (err) {
    console.log(err.response.data);
  }
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
  try {

    var response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
    var searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
  } catch (err) {
    console.log(err.response.data);
  }
  state.subtopics = await response.json();
  state.searchObject = await searchObject.json();
  state.pages = state.searchObject.pages;

  document.querySelector('.select_topic').innerHTML = "";
  document.querySelector('.subtopics').innerHTML = "";
  const option = document.createElement("option");
  option.value = 0;
  parseFloat(state.topic_id) === 0 && option.setAttribute("selected", "selected");
  document.querySelector('.select_topic').appendChild(option);
  contentGenerator(true, state.isAdmin);
  paginationLogic("1");
  setAttribute();
  if (!state.pages) {
    document.querySelector('.subtopics').innerHTML = "<p style='margin: auto; font-size: 40px;font-weight: 700;'>No" +
        " results found!</p>";
    document.querySelector('.page_number').textContent = "";
  }
};

const onClick = async subtopic_id => {
  try {
    var response = await fetch(`http://localhost:8080/${state.path}/api/subtopics`,
        {
          method: "POST",
          body: `subtopicid=${subtopic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
  } catch (err) {
    console.log(err.response.data);
  }
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
  try {
    var response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
  } catch (err) {
    console.log(err.response.data);
  }
  state.subtopics = await response.json();
  document.querySelector('.subtopics').innerHTML = "";
  contentGenerator(false, state.isAdmin);
  paginationLogic("2");
  changePageNumber();
};

const clickNext = async () => {
  state.pageNumber++;
  try {
    var response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
  } catch (err) {
    console.log(err.response.data);
  }
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
          .setAttribute("onclick", `clickShow('.delete_popup',${subtopic.id})`);
      document.querySelectorAll('.fa-edit')[i]
          .setAttribute("onclick", `clickShow('.update_form_popup',${subtopic.id})`);
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

const clickShow = async (type, subtopic_id) => {
  overlayLogic(true, `clickHide('${type}')`);
  document.querySelector(type).style.visibility = "visible";
  document.querySelector(type).style.top = "50%";
  if (type === ".login_popup" || type === ".logout_popup") {
  } else {
    switch (type) {
      case ".delete_popup":
        document.querySelector('.delete_button')
            .setAttribute("onclick", `clickDelete(${subtopic_id});clickHide('${type}')`);
        break;
      case ".create_form_popup":
        state.topics.forEach(topic => {
          const option = document.createElement("option");
          option.textContent = topic.topic;
          option.value = topic.id;
          document.querySelector('.select').appendChild(option);
        });

        const event = new Event("change");

        document.querySelector('.select').dispatchEvent(event);
        break;
      case ".update_form_popup":
        try {
          var response = await fetch(`http://localhost:8080/${state.path}/api/subtopics`,
              {
                method: "POST",
                body: `subtopicid=${subtopic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
                headers:
                    {
                      "Content-Type": "application/x-www-form-urlencoded"
                    }
              });
        } catch (err) {
          console.log(err.response.data);
        }

        const json = await response.json();
        state.description = json.description.description;
        state.body_html = json.description.body_HTML;
        state.examplesObject = json.exampleList;

        document.querySelector(".examples_textarea") !== null
        &&
        document.querySelector(type).removeChild(document.querySelector(".examples_textarea"));

        state.examplesList = [];

        const div = document.createElement("div");
        div.className = "examples_textarea";

        document.querySelector(type).appendChild(div);

        json.exampleList.forEach((element, i) => {
          let textarea = document.createElement("textarea");
          textarea.value = element.body_html;
          textarea.onkeyup = event => {
            state.examplesList.forEach(element =>
                element.id === state.examplesList[i].id
                &&
                (element.body_html = event.target.value))
          };
          state.examplesList.push({
            id: element.id,
            body_html: element.body_html
          });

          document.querySelector(".examples_textarea").append(textarea);
        });

        document.querySelectorAll('.description_html_textarea')[1].value = state.description;
        document.querySelector('.update_subtopic_button')
            .setAttribute("onclick", `clickUpdate(${subtopic_id});clickHide('${type}')`);
        break;
      default:
        console.log("more cases pls");
        break;
    }
  }
};

const clickHide = type => {
  overlayLogic(false);
  document.querySelector(type).style.visibility = "hidden";
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
      clickHide('.login_popup');
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

const clickLogout = () => {
  state.isAdmin = false;
  setTimeout(() => {
    document.querySelector('.subtopics').innerHTML = "";
    contentGenerator(false, state.isAdmin);
    document.querySelector('.adminpage_logout').style.display = "none";
    document.querySelector('.admin_create').style.display = "none";
    document.querySelector('.adminpage_login').style.display = "inline-block";
  }, 500);
};

const clickDelete = async subtopic_id => {

  try {

    await fetch(`http://localhost:8080/${state.path}/admin/delete`,
        {
          method: "POST",
          body: `subtopicid=${subtopic_id}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
    var response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
    var searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
  } catch (err) {
    console.log(err.response.data);
  }
  state.subtopics = await response.json();
  state.searchObject = await searchObject.json();
  if (state.pages > state.searchObject.pages) {
    state.pages--;
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
    paginationLogic("4");
    changePageNumber();
  }
  document.querySelector('.subtopics').innerHTML = "";
  contentGenerator(false, state.isAdmin);
};

const clickCreate = async () => {
  try {

    await fetch(`http://localhost:8080/${state.path}/admin/create`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&subtopicname=${state.subtopic_name}&descriptionHTML=${state.description}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
    var response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
    var searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
        {
          method: "POST",
          body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });

  } catch (err) {
    console.log(err.response.data);
  }
  state.subtopics = await response.json();
  state.searchObject = await searchObject.json();
  if (state.pages < state.searchObject.pages) {
    state.pages++;
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
    paginationLogic("4");
    changePageNumber();
  }
  document.querySelector('.subtopics').innerHTML = "";
  contentGenerator(false, state.isAdmin);
};

const clickUpdate = async subtopic_id => {
  const examplesList = JSON.stringify(state.examplesList);
  try {
    await fetch(`http://localhost:8080/${state.path}/admin/update`,
        {
          method: "POST",
          body: `subtopicid=${subtopic_id}&descriptionHTML=${state.description}&examplesList=${examplesList}`,
          headers:
              {
                "Content-Type": "application/x-www-form-urlencoded"
              }
        });
  } catch (err) {
    console.log(err.response.data);
  }
};

















