let state = {
  topics: [],
  subtopics: [],
  filtered_subtopics: [],
  topic_id: 0,
  search_keyword: "",
  pageNumber: 1,
};

const request = async () => {
  const topics = await fetch("http://localhost:8080/com_Saras_Web_exploded/api/topics");
  const subtopics = await fetch("http://localhost:8080/com_Saras_Web_exploded/api/subtopics");
  state.topics = await topics.json();
  state.subtopics = await subtopics.json();
};

const changeState = (e, name) => state[name] = e.target.value;

window.onload = async () => {

  await request();

  const app = document.querySelector("#app");

  converter(Home, app);

  state.topics.forEach(topic => {
    const option = document.createElement("option");
    option.textContent = topic.topic;
    option.value = topic.id;
    document.querySelector('.select_topic').appendChild(option);
  });

  state.subtopics.forEach((subtopic, i) => {
    const div = document.createElement("div");
    div.className = "subtopic";

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
  document.querySelector('.search').setAttribute("value", state.search_keyword);
  document.querySelector('.page_number').textContent = state.pageNumber;
};


// const onSubmit = async (e) => {
//   e.preventDefault();
//   const response = await fetch("http://localhost:8080/com_Saras_Web_exploded/api/topics",
//       {
//         method: "POST",
//
//         // whatever data you want to post with a key-value pair
//
//         body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
//         headers:
//             {
//               "Content-Type": "application/x-www-form-urlencoded"
//             }
//       });
//   state.subtopics = await response.json();
//
//   document.querySelector(".container").innerHTML = "";
//
//   state.subtopics.forEach((subtopic, i) => {
//     const form = document.createElement("form");
//     form.action = "subtopic";
//     form.method = "post";
//     form.className = "tableForm";
//
//     document.querySelector('.subtopics').appendChild(form);
//
//     const input = document.createElement("input");
//     input.type = "hidden";
//     input.name = "subtopicid";
//     input.value = subtopic.id;
//
//     document.querySelectorAll('.tableForm')[i].appendChild(input);
//
//
//     const button = document.createElement("button");
//     button.type = "submit";
//     button.className = "subtopic_submit";
//
//     document.querySelectorAll('.tableForm')[i].appendChild(button);
//
//     const topicSpan = document.createElement("span");
//     topicSpan.className = "topicSpan";
//     topicSpan.textContent = subtopic.topicId;
//
//     const subtopicSpan = document.createElement("span");
//     subtopicSpan.className = "subtopicSpan";
//     subtopicSpan.textContent = subtopic.subTopic;
//
//     document.querySelectorAll(".subtopic_submit")[i].appendChild(topicSpan);
//     document.querySelectorAll(".subtopic_submit")[i].appendChild(subtopicSpan);
//
//
//   });
// };

const onChange = async () => {

  const response = await fetch("http://localhost:8080/com_Saras_Web_exploded/api/topics",
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

  // Full page rebuild

  // const app = document.querySelector("#app");
  //
  // app.innerHTML = "";

  // converter(Home, app);

  // ***********************************************

  // Rebuild only some elements
  const select = document.querySelector('.select_topic');
  const subtopics = document.querySelector('.subtopics');

  select.innerHTML = "";
  subtopics.innerHTML = "";

  const option = document.createElement("option");
  option.value = 0;
  console.log(state.topic_id);
  parseFloat(state.topic_id) === 0 ? option.setAttribute("selected", "selected") : null;
  document.querySelector('.select_topic').appendChild(option);

// *************************************************


  state.topics.forEach(topic => {
    const option = document.createElement("option");
    option.textContent = topic.topic;
    option.value = topic.id;
    parseFloat(state.topic_id) === topic.id ? option.setAttribute("selected", "selected") : null;
    document.querySelector('.select_topic').appendChild(option);
  });

  state.subtopics.forEach((subtopic, i) => {
    const div = document.createElement("div");
    div.className = "subtopic";

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

  document.querySelector('.search').setAttribute("value", state.search_keyword);


  // document.querySelector('.numba!').textContent = state.pageNumber;
};

const clickBack = () => history.back();

const clickNext = async () => {

  const response = await fetch("http://localhost:8080/com_Saras_Web_exploded/api/subtopics",
      {
        method: "POST",

        // whatever data you want to post with a key-value pair

        body: `topics=${state.topic_id}&pageNumber=${state.pageNumber}&subtopicsearch=${state.search_keyword}`,
        headers:
            {
              "Content-Type": "application/x-www-form-urlencoded"
            }
      });
  const json = response.json();
  console.log(json);
};





