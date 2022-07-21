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
        console.log(resp[i].title);
        str += "<tr>"
        str += "<td>" + '<img src="' + resp[i].image_url + '">' + "</td>"
        str += "<td>" + resp[i].title + "</td>"
        str += "<td>" + "<button type='button' name='registerBtn' id='registerBtn' value='" + resp[i].registered_book_id + "' onclick=registerBookButton('" + resp[i].registered_book_id + "')>register</button>" + "</td>"
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

  var jsonData = {"sellStatus":1, "registeredBookId":id};


  var sel = document.getElementById("subCategorySelect");
  var val = sel.options[sel.selectedIndex].value;
  var selectData = {"sellerId":1, "category":val, "sellStatus":0};

  $.ajax({
    url:"updateSellStatus.do",
    type:"POST",
    data: JSON.stringify(jsonData),
    contentType: "application/json; charset-UTF-8",

    success: function (result) {
      alert("success!");
      alert(result);

      getNotRegisteredBooks("category.do", selectData);

    },
    error: function () {
      alert("fail");
    }
  });

}

function subChangeBooks() {
  var sel = document.getElementById("subCategorySelect");
  var val = sel.options[sel.selectedIndex].value;

  console.log(val);

  var jsonData = {"sellerId":"1", "category":val, "sellStatus":0};

  getNotRegisteredBooks("category.do", jsonData);

}

function subSearchButton() {

  var sel = document.getElementById("subCategorySelect");
  var val = sel.options[sel.selectedIndex].value;
  var keyword = document.getElementById("subKeyword").value;

  var jsonData = {"sellerId":"1", "category":val, "keyword":keyword, "sellStatus":0};

  getNotRegisteredBooks("keyword.do", jsonData);
}

function subInputTextCheck() {
  var input = document.getElementById("subKeyword").value;

  if (input == '') {
    var sel = document.getElementById("subCategorySelect");
    var val = sel.options[sel.selectedIndex].value;

    var jsonData = {"sellerId":"1", "category":val, "sellStatus":0};

    getNotRegisteredBooks("category.do", jsonData);

  }

}