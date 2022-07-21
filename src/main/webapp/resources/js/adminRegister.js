function getNotRegisteredBooks(doUrl, jsonData) {

  $.ajax({
    url:doUrl,
    type:"POST",
    data:JSON.stringify(jsonData),
    contentType: 'application/json; charset=UTF-8',
    dataType: 'json',
    success: function(resp) {
      var str = "";
      $("#subtable").children().remove();

      $.each(resp, function (i) {
        str += "<tr>"
        str += "<td>" + '<img id="bookImg" src="' + resp[i].image_url + '">' + "</td>"
        str += "<td>" + resp[i].title + "</td>"
        str += "<td>" + "<button type='button' name='registerBtn' id='registerBtn' value='" + resp[i].book_id + "' onclick=registerBookButton('" + resp[i].book_id + "')>register</button>" + "</td>"
        str += "</tr>"
      });

      $("#subtable").append(str);

    },
    error : function () {
      alert("error!");
    }

  });
}

function registerBookButton(id) {

  var jsonData = {"bookId": id};

  $.ajax({
    url:"registerDetail.do",
    type:"POST",
    data: JSON.stringify(jsonData),
    contentType: "application/json; charset=UTF-8",
    dataType: "json",

    success: function(resp) {
      if(resp.result == null) {
        var id = resp.bookId;

        location.href = "registerBookDetail.do?bookId=" + id;
      }else {
        location.href = "adminMain.do";
      }
    },
    error: function () {
      alert("fail");
    }
  });

}

function subChangeBooks() {
  var sel = document.getElementById("subCategorySelect");
  var val = sel.options[sel.selectedIndex].value;

  var jsonData = {"category":val};

  getNotRegisteredBooks("notRegisteredBooks.do", jsonData);

}

function subSearchButton() {

  var sel = document.getElementById("subCategorySelect");
  var val = sel.options[sel.selectedIndex].value;
  var keyword = document.getElementById("subKeyword").value;

  var jsonData = {"category":val, "keyword":keyword, "sellStatus":0};

  getNotRegisteredBooks("notRegisteredBooksByKeyword.do", jsonData);
}

function subInputTextCheck() {
  var input = document.getElementById("subKeyword").value;

  if (input == '') {
    var sel = document.getElementById("subCategorySelect");
    var val = sel.options[sel.selectedIndex].value;

    var jsonData = {"category":val, "sellStatus":0};

    getNotRegisteredBooks("notRegisteredBooks.do", jsonData);

  }

}