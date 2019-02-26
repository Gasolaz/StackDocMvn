


let input_Value;

function changed(e) {

    console.log(e.target.value);

     input_Value = e.target.value;
}



function clicked(e) {

    fetch("http://localhost:8080/StackDocMvn_Web_exploded/", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
            "Access-Control-Origin": "*"
        },
        body: `pageNumber=${e.target.textContent}`
               
    })
}

function back() {

    history.back();
}


