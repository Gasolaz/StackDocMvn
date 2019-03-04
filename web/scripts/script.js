const state = {
  topics: [],
  subtopics: [],
  topic_id: 0,
  search_keyword: "",
  pageNumber: 1,
  searchObject: {},
  pages: "",
  path: "com_Saras_Web_exploded"
};

const request = async () => {
  // get topics
  const topics = await fetch(`http://localhost:8080/${state.path}/api/topics`);
  // get subtopics
  const subtopics = await fetch(`http://localhost:8080/${state.path}/api/subtopics`);
  // get searchObject
  const searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
      {
        method: "POST",
        // whatever data you want to post with a key-value pair
        body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });

  // set application state
  state.topics = await topics.json();
  state.subtopics = await subtopics.json();
  state.searchObject = await searchObject.json();
  state.pages = state.searchObject.pages;
};

const changeState = (e, name) => state[name] = e.target.value; // binding state properties to searching fields

window.onload = async () => { // when window object is loaded (with dom elements)

  await request(); // fire ajax function

  const app = document.querySelector('#app'); // div with id = app (main div)

  converter(Home, app); // fire converter to build home page, only template without content

  contentGenerator(true);

  const previous = document.querySelector('.previous');
  const next = document.querySelector('.next');

  previous.style.visibility = "hidden";
  state.pageNumber < state.pages ? next.style.visibility = "visible" : next.style.visibility = "hidden";

  // binding state properties to searching fields values and page number
  setAttribute();
};

const onChange = async () => { // when select or input value has changed

  state.pageNumber = 1;

  // post request to get filtered topics
  const response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
      {
        method: "POST",
        // whatever data you want to post with a key-value pair
        body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });

  const searchObject = await fetch(`http://localhost:8080/${state.path}/api/search`,
      {
        method: "POST",
        // whatever data you want to post with a key-value pair
        body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });

  // set application state
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
  const select = document.querySelector('.select_topic');
  const subtopics = document.querySelector('.subtopics');

  // set content to empty
  select.innerHTML = "";
  subtopics.innerHTML = "";

  const option = document.createElement("option");
  option.value = 0;
  parseFloat(state.topic_id) === 0 && option.setAttribute("selected", "selected");
  document.querySelector('.select_topic').appendChild(option);

  // *************************************************

  contentGenerator(true);

  const previous = document.querySelector('.previous');
  const next = document.querySelector('.next');

  state.pageNumber < state.pages ? next.style.visibility = "visible" : next.style.visibility = "hidden";
  state.pageNumber > 1 ? previous.style.visibility = "visible" : previous.style.visibility = "hidden";

  setAttribute();
};

const onClick = async id => {

  const response = await fetch(`http://localhost:8080/${state.path}/api/subtopics`,
      {
        method: "POST",
        // whatever data you want to post with a key-value pair
        body: `subtopicid=${id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });

  const json = await response.json();

  const app = document.querySelector('#app');

  app.innerHTML = "";

  converter(Description, app);

  document.querySelector('.subtopic_title').textContent = json.sub_topic;

  document.querySelector('.content').innerHTML += json.description;
  document.querySelector('.content').innerHTML += json.body_HTML;
};

const clickPrevious = async () => {

  state.pageNumber--;

  const response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
      {
        method: "POST",

        // whatever data you want to post with a key-value pair

        body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });

  state.subtopics = await response.json();

  const subtopics = document.querySelector('.subtopics');

  subtopics.innerHTML = "";

  contentGenerator(false);

  const previous = document.querySelector('.previous'),
      next = document.querySelector('.next');

  next.style.visibility = "visible";
  state.pageNumber > 1 ? previous.style.visibility = "visible" : previous.style.visibility = "hidden";

  changePageNumber();
};

const clickNext = async () => {

  state.pageNumber++; // page number +1

  const response = await fetch(`http://localhost:8080/${state.path}/api/topics`,
      {
        method: "POST",

        // whatever data you want to post with a key-value pair

        body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });

  state.subtopics = await response.json();

  const subtopics = document.querySelector('.subtopics');

  subtopics.innerHTML = "";

  contentGenerator(false);

  const previous = document.querySelector('.previous'),
      next = document.querySelector('.next');

  previous.style.visibility = "visible";

  state.pageNumber < state.pages
      ?
      next.style.visibility = "visible"
      :
      next.style.visibility = "hidden";

  changePageNumber();
};

const clickBack = () => {
  const app = document.querySelector("#app");

  app.innerHTML = "";

  converter(Home, app);

  contentGenerator(true);

  const previous = document.querySelector('.previous'),
      next = document.querySelector('.next');

  state.pageNumber < state.pages ? next.style.visibility = "visible" : next.style.visibility = "hidden";
  state.pageNumber > 1 ? previous.style.visibility = "visible" : previous.style.visibility = "hidden";

  setAttribute();
};

const setAttribute = () => {
  document.querySelector('.search').setAttribute("value", state.search_keyword);
  document.querySelector('.select_topic').setAttribute("value", state.topic_id);
  document.querySelector('.page_number').textContent = state.pageNumber;
};

const changePageNumber = () => document.querySelector('.page_number').textContent = state.pageNumber;

const contentGenerator = requireTopics => {

  requireTopics

  &&

  state.topics.forEach(topic => {
    const option = document.createElement("option");
    option.textContent = topic.topic;
    option.value = topic.id;
    parseFloat(state.topic_id) === topic.id && option.setAttribute("selected", "selected");
    document.querySelector('.select_topic').appendChild(option);
  });

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







