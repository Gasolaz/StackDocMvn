const converter = (json, parent) => {
  if (json instanceof Array) {
  } else if (json instanceof Object) {
    for (var key in json) {
      if (json[key] instanceof Array) {
        json[key].forEach(el => {
          var child = document.createElement(key);
          parent.appendChild(child);
          converter(el, child);
        })
      } else if
      (
          key === "button"
          ||
          key === "h2"
          ||
          key === "div"
          ||
          key === "header"
          ||
          key === "nav"
          ||
          key === "a"
          ||
          key === "img"
          ||
          key === "ul"
          ||
          key === "li"
          ||
          key === "span"
          ||
          key === "h1"
          ||
          key === "p"
          ||
          key === "i"
          ||
          key === "select"
          ||
          key === "option"
          ||
          key === "input") {
        var child = document.createElement(key);
        parent.appendChild(child);
      }
      if (key === "type" || key === "id" || key === "class" || key === "href" || key === "src" || key === "alt" || key === "width" || key === "height" || key === "selected" || key === "onchange" || key === "onkeyup" || key === "onclick" || key === "value" || key === "placeholder" || key === "autofocus")
        parent.setAttribute(key, json[key]);
      else if (key === "text") parent.textContent = json[key];
      else converter(json[key], child);
    }
  } else parent.textContent = json;
};





