const Home = {
  "div": {
    "class": "home",
    "header": {
      "div": [
        {
          "class": "logo",
          "i": {
            "class": "fab fa-stack-overflow"
          },
          "h1": "StackOverflow Documentation Search Engine"
        },
        {
          "class": "admin_buttons",
          "button": [
            {
              "class": "adminpage_login",
              "text": "ADMIN",
              "onclick": "clickLogin()"
            },
            {
              "class": "adminpage_logout",
              "text": "LOGOUT",
              "onclick": "clickLogout()"
            },
          ]
        }
      ]
    },
    "div": {
      "class": "container",
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
            "onkeyup": "changeState(event, 'search_keyword');onChange()",
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
              "class": "previous",
              "text": "previous",
              "onclick": "clickPrevious()"
            },
            {
              "class": "next",
              "text": "next",
              "onclick": "clickNext()"
            }
          ],
          "p": {
            "class": "page_number"
          }
        }
      ]
    }
  }
};
