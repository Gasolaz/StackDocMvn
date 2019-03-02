const Home = {
  "div": {
    "class": "home",
    "h1": "StackOverflow Documentation Search Engine",
    "div": [
      {
        "class": "search_fields",
        "select": {
          "class": "select_topic",
          "onchange": "changeState(event, 'topic_id');onChange()",
          "option": {
            "selected": "selected",
            "value": "0"
          }
        },
        "input": {
          "class": "search",
          "type": "text",
          "placeholder": "Search...",
          "autofocus": "true",
          "onchange": "changeState(event, 'search_keyword');onChange()",
        }
      },
      {
        "class": "header",
        "p": ["Topic", "Subtopic"]
      },
      {
        "class": "subtopics"
      },
      {
        "class": "pages",
        "button": [
          {
            "class": "back",
            "text": "Back",
            "onclick": "clickBack()"
          },
          {
            "class": "next",
            "text": "Next",
            "onclick": "clickNext()"
          }
        ],
        "p": {
          "class": "page_number"
        }
      }
    ]
  }
};
