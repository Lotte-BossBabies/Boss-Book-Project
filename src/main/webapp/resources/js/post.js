
function userSelectPost(){
    let form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "userSelect.do");
    document.body.appendChild(form);
    form.submit();
}

function findIdPost(){
    let form = document.createElement("form");
    form.setAttribute("method", "get");
    form.setAttribute("action", "findIdView.do");
    document.body.appendChild(form);
    form.submit();
}

function findPasswordPost(){
    let form = document.createElement("form");
    form.setAttribute("method", "get");
    form.setAttribute("action", "findPasswordView.do");
    document.body.appendChild(form);
    form.submit();
}

function passwordFind(password){
    let form = document.createElement("form");
    form.method = "post";
    form.action = "findPasswordOk.do";

    let input = document.createElement('input');
    input.setAttribute("type", "hidden");
    input.setAttribute("name", "password");
    input.setAttribute("value", password);
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();
}
function idFind(id){
    let form = document.createElement("form");
    form.method = "post";
    form.action = "findIdOk.do";

    let input = document.createElement('input');
    input.setAttribute("type", "hidden");
    input.setAttribute("name", "id");
    input.setAttribute("value", id);
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();
}

function myPagePost(){
    let form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "updateUser.do");
    document.body.appendChild(form);
    form.submit();
}
