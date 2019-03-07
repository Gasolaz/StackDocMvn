const state = {
  topics: [],
  subtopics: [],
  topic_id: 0,
  search_keyword: "",
  pageNumber: 1,
  searchObject: {},
  pages: "",
  path: "StackDocMvn_Web_exploded",
  pass: "123"
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

const changeState = (e, name) => state[name] = e.target.value; // binding state properties to searching fields

window.onload = async () => { // when window object is loaded (with dom elements)
  await request();
  templateGenerator(false, Home);
  contentGenerator(true); ///
  paginationLogic("1");
  setAttribute();   // binding state properties to searching fields values and page number
};

const onChange = async () => { // when select or input value has changed
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
  contentGenerator(true); ///
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

  document.querySelector('.subtopic_title').textContent = json.sub_topic;
  document.querySelector('.content').innerHTML += json.description;
  document.querySelector('.content').innerHTML += json.body_HTML;
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
  contentGenerator(false); ///
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
  contentGenerator(false); ///
  paginationLogic("3");
  changePageNumber();
};

const clickBack = () => {
  templateGenerator(true, Home);
  contentGenerator(true);
  paginationLogic("4");
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

const contentGenerator = requireTopics => {
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
    document.querySelector('.subtopics').appendChild(div);
    const topic_name = document.createElement("span");
    topic_name.className = "topic_name";
    topic_name.textContent = subtopic.topicId;
    const subtopic_name = document.createElement("span");
    subtopic_name.className = "subtopic_name";
    subtopic_name.textContent = subtopic.subTopic;
    document.querySelectorAll(".subtopic")[i].appendChild(topic_name);
    document.querySelectorAll(".subtopic")[i].appendChild(subtopic_name);
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

const clickLogin = async () => {
  const response = await fetch(`http://localhost:8080/${state.path}/admin`,
      {
        method: "POST",
        body: `pass=${state.password}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });

  state.subtopics = await response.json();

  document.querySelector('.subtopics').innerHTML = "";


  state.subtopics.forEach((subtopic, i) => {
    const div = document.createElement("div");
    div.className = "subtopic";
    div.setAttribute("onclick", `onClick(${subtopic.id})`);
    document.querySelector('.subtopics').appendChild(div);
    const topic_name = document.createElement("span");
    topic_name.className = "topic_name";
    topic_name.textContent = subtopic.topicId;
    const subtopic_name = document.createElement("span");
    subtopic_name.className = "subtopic_name";
    subtopic_name.textContent = subtopic.subTopic;
    const subtopic_delete = document.createElement("span");
    subtopic_delete.className = "subtopic_delete";
    subtopic_delete.innerHTML = "<i class='fas fa-times'></i>";
    subtopic_delete.setAttribute("onclick", `clickDelete(${subtopic.id})`);
    document.querySelectorAll(".subtopic")[i].appendChild(topic_name);
    document.querySelectorAll(".subtopic")[i].appendChild(subtopic_name);
    document.querySelectorAll(".subtopic")[i].appendChild(subtopic_delete);
  });

  document.querySelector('.adminpage_logout').style.visibility = "visible";
  document.querySelector('.adminpage_login').style.visibility = "hidden";

};

const clickLogout = async () => await fetch(`http://localhost:8080/${state.path}/admin`);

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

  state.subtopics.forEach((subtopic, i) => {
    const div = document.createElement("div");
    div.className = "subtopic";
    div.setAttribute("onclick", `onClick(${subtopic.id})`);
    document.querySelector('.subtopics').appendChild(div);
    const topic_name = document.createElement("span");
    topic_name.className = "topic_name";
    topic_name.textContent = subtopic.topicId;
    const subtopic_name = document.createElement("span");
    subtopic_name.className = "subtopic_name";
    subtopic_name.textContent = subtopic.subTopic;
    const subtopic_delete = document.createElement("span");
    subtopic_delete.className = "subtopic_delete";
    subtopic_delete.innerHTML = "<i class='fas fa-times'></i>";
    subtopic_delete.setAttribute("onclick", `clickDelete(${subtopic.id})`);
    console.log(subtopic)
    subtopic_delete.setAttribute("onmouseover", subtopic.removeAttribute("onclick"));
    subtopic_delete.setAttribute("onmouseout", subtopic.setAttribute("onclick", `onClick(${subtopic_id})`));
    document.querySelectorAll(".subtopic")[i].appendChild(topic_name);
    document.querySelectorAll(".subtopic")[i].appendChild(subtopic_name);
    document.querySelectorAll(".subtopic")[i].appendChild(subtopic_delete);
  });


};












