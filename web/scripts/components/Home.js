const Home = {
  "div": [
    {
      "class": "home",
      "div": {
        "class": "container",
        "header": {
          "button": {
            "class": "admin_create",
            "text": "CREATE",
            "onclick": "clickShow('.create_form_popup')"
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
                  "text": "LOGIN",
                  "onclick": "clickShow('.login_popup')"
                },
                {
                  "class": "adminpage_logout",
                  "text": "LOG OUT",
                  "onclick": "clickShow('.logout_popup')"
                },
              ]
            }
          ],
        },
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
                  "onclick": "clickHide('.login_popup')"
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
                "onclick": "clickLogout();clickHide('.logout_popup')"
              },
              {
                "class": "cancel_logout",
                "text": "CANCEL",
                "onclick": "clickHide('.logout_popup')"
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
                "onclick": "clickHide('.delete_popup')"
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
                "class": "description",
                "text": "Description:"
              }
            ],
            "input": {
              "class": "subtopic_name_input",
              "onkeyup": "changeState(event, 'subtopic_name')"
            },
            "textarea": {
              "class": "description_html_textarea",
              "onkeyup": "changeState(event, 'description')"
            },
            "div": {
              "class": "create_form_buttons",
              "button": [
                {
                  "class": "create_subtopic_button",
                  "text": "CREATE SUBTOPIC",
                  "onclick": "clickCreate();clickHide('.create_form_popup')"
                },
                {
                  "class": "cancel_create_subtopic",
                  "text": "CANCEL",
                  "onclick": "clickHide('.create_form_popup')"
                }
              ]
            }
          },
          {
            "class": "update_form_popup",
            "p": [
              {
                "class": "description",
                "text": "Description:"
              },
              {
                "class": "examples",
                "text": "Examples:"
              }
            ],
            "textarea": {
              "class": "description_html_textarea",
              "onkeyup": "changeState(event, 'description')"
            },
            "div": {
              "class": "update_form_buttons",
              "button": [
                {
                  "class": "update_subtopic_button",
                  "text": "UPDATE SUBTOPIC"
                },
                {
                  "class": "cancel_update_subtopic",
                  "text": "CANCEL",
                  "onclick": "clickHide('.update_form_popup')"
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
    },
    {
      "class": "overlay"
    }
  ]
};
