const Home = {
  "div": {
    "class": "home",
    "header": {
      "button": {
        "class": "admin_create",
        "text": "CREATE",
        "onclick": "clickShowCreate()"
      },
      "div": [
        {
          "class": "logo",
          "i": {
            "class": "fab fa-stack-overflow"
          },
          "h1": "StackOverflow Documentation Search Engine",
        },
        {
          "class": "admin_buttons",
          "button": [
            {
              "class": "adminpage_login",
              "text": "ADMIN",
              "onclick": "clickShowLogin()"
            },
            {
              "class": "adminpage_logout",
              "text": "LOG OUT",
              "onclick": "clickShowLogout()"
            },
          ]
        }
      ],
    },
    "div": {
      "class": "container",
      "div": [
        {
          "class": "login_popup",
          "p": {
            "class": "pass",
            "text": "Enter password:"
          },
          "input": {
            "class": "password_input",
            "type": "password",
            "onkeyup": "changeState(event, 'pass')"
          },
          "div": {
            "class": "password_buttons",
            "button": [
              {
                "class": "login_button",
                "text": "LOG IN",
                "onclick": "clickLogin()"
              },
              {
                "class": "cancel_login",
                "text": "CANCEL",
                "onclick": "clickHideLogin()"
              }
            ]
          }
        },
        {
          "class": "logout_popup",
          "p": "Are you sure?",
          "button": [
            {
              "class": "logout_button",
              "text": "LOG OUT",
              "onclick": "clickLogout()"
            },
            {
              "class": "cancel_logout",
              "text": "CANCEL",
              "onclick": "clickHideLogout()"
            }
          ]

        },
        {
          "class": "delete_popup",
          "p": "Are you sure?",
          "button": [
            {
              "class": "delete_button",
              "text": "DELETE"
            },
            {
              "class": "cancel_delete",
              "text": "CANCEL",
              "onclick": "clickHideDelete()"
            }
          ]
        },
        {
          "class": "update_popup",
          "p": "Are you sure?",
          "button": [
            {
              "class": "update_button",
              "text": "UPDATE"
            },
            {
              "class": "cancel_update",
              "text": "CANCEL",
              "onclick": "clickHideUpdate()"
            }
          ]
        },
        {
          "class": "create_popup",
          "p": "Are you sure?",
          "button": [
            {
              "class": "create_button",
              "text": "CREATE",
              "onclick": "clickShowCreateForm()"
            },
            {
              "class": "cancel_create",
              "text": "CANCEL",
              "onclick": "clickHideCreate()"
            }
          ]
        },
        {
          "class": "create_form_popup",
          "select": {
            "class": "select",
            "onchange": "changeState(event, 'topic_id')",
          },
          "p": [
            {
              "class": "subtopic_name",
              "text": "Subtopic name:"
            },
            {
              "class": "description_html",
              "text": "Description HTML:"
            }
          ],
          "input": {
            "type" : "text",
            "class": "subtopic_name_input",
            "onkeyup": "changeState(event, 'subtopic_name')"
          },
          "textarea": {
            "class": "description_html_textarea",
            "onkeyup": "changeState(event, 'description_HTML')"
          },
          "div": {
            "class": "create_form_buttons",
            "button": [
              {
                "class": "create_subtopic_button",
                "text": "CREATE SUBTOPIC",
                "onclick": "clickCreate();clickHideCreateForm()"
              },
              {
                "class": "cancel_create_subtopic",
                "text": "CANCEL",
                "onclick": "clickHideCreateForm()"
              }
            ]
          }
        },
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
