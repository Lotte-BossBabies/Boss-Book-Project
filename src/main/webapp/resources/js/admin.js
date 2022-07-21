function getBooks(doUrl, jsonData) {

  $.ajax({
    url:doUrl,
    type:"POST",
    data:JSON.stringify(jsonData),
    contentType: 'application/json; charset=UTF-8',
    dataType: 'json',
    success: function(resp) {
      var str = "";
      $("#maintable").children().remove();

      if(doUrl === "sales.do") {
        $.each(resp, function (i) {
          console.log(resp[i].image_url);
          str += "<tr>"
          str += "<td>" + '<img id="bookImg" src="' + resp[i].image_url + '">' + "</td>"
          str += "<td>" + resp[i].title + "</td>"
          str += "<td>" + resp[i].order_count + "</td>"
          str += "<td>" + "<button type='button' name='editBtn' id='editBtn' value='" + resp[i].registered_book_id + "' onclick=editButton('" + resp[i].registered_book_id + "')>edit</button>" + "</td>"
          str += "<td>" + "<button type='button' name='cancelBtn' id='cancelBtn' value='" + resp[i].registered_book_id + "' onclick=cancelBookButton('" + resp[i].registered_book_id + "')>cancel</button>" + "</td>"

          str += "</tr>"
        });
      }else {
        $.each(resp, function (i) {
          console.log(resp[i].image_url);
          str += "<tr>"
          str += "<td>" + '<img id="bookImg" src="' + resp[i].image_url + '">' + "</td>"
          str += "<td>" + resp[i].title + "</td>"
          str += "<td>" + "<button type='button' name='editBtn' id='editBtn' value='" + resp[i].registered_book_id + "' onclick=editButton('" + resp[i].registered_book_id + "')>edit</button>" + "</td>"
          str += "<td>" + "<button type='button' name='cancelBtn' id='cancelBtn' value='" + resp[i].registered_book_id + "' onclick=cancelBookButton('" + resp[i].registered_book_id + "')>cancel</button>" + "</td>"


          str += "</tr>"
        });
      }

      $("#maintable").append(str);

    },
    error : function () {
      alert("error!");
    }

  });
}


function changeBooks() {
    var sel = document.getElementById("categorySelect");
    var val = sel.options[sel.selectedIndex].value;

    console.log(val);

    var jsonData = {"category":val, "sellStatus":1};

    getBooks("category.do", jsonData);
}


function searchButton() {

  var sel = document.getElementById("categorySelect");
  var val = sel.options[sel.selectedIndex].value;
  var keyword = document.getElementById("keyword").value;

  var jsonData = {"category":val, "keyword":keyword, "sellStatus":1};

  getBooks("keyword.do", jsonData);

}


function inputTextCheck() {
  var input = document.getElementById("keyword").value;

  if (input == '') {
    var sel = document.getElementById("categorySelect");
    var val = sel.options[sel.selectedIndex].value;

    var jsonData = {"category":val, "sellStatus":1};

    getBooks("category.do", jsonData);

  }
}

function salesButton() {
  var sel = document.getElementById("categorySelect");
  var val = sel.options[sel.selectedIndex].value;

  var jsonData = {"category":val, "sellStatus":1};

  getBooks("sales.do", jsonData);
}

function editButton(id) {

  location.href = "/bookEdit.do?registeredBookId=" + id;

}

function cancelBookButton(id) {
  var jsonData = {"sellStatus":0, "registeredBookId":id};

  var sel = document.getElementById("categorySelect");
  var value = sel.options[sel.selectedIndex].value;
  var bookData = {"category":value, "sellStatus":1};


  $.ajax({
    url:"updateSellStatus.do",
    type:"POST",
    data:JSON.stringify(jsonData),
    contentType: "application/json; charset=UTF-8",

    success: function (result) {
      alert("success");

      getBooks("category.do", bookData);

    },
    error: function () {
      alert("fail");
    }
  });
}

function updateButton() {

  var stock = document.getElementById("stock").value;
  var discount = document.getElementById("discount").value;
  var id = document.getElementById("updateBtn").value;

  var jsonData = {"stock":stock, "discount":discount, "id":id, "sellStatus":1};

  $.ajax({
    url:"update.do",
    type:"POST",
    data:JSON.stringify(jsonData),
    contentType: "application/json; charset=UTF-8",

    success: function (result) {
      alert("sucess!");

      location.href = "/adminMain.do";

    },
    error: function () {
      alert("error...");
    }
  });

}

function cancelButton() {
  location.href = "/adminMain.do";
}

/*--------------------------------------------------------------------------------------*/

