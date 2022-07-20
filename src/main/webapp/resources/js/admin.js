
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

      $.each(resp, function (i) {
        console.log(resp[i].image_url);
        str += "<tr>"
        str += "<td>" + '<img src="' + resp[i].image_url + '">' + "</td>"
        str += "<td>" + resp[i].title + "</td>"
        str += "<td>" + '<button type="button" name="editBtn" id="editBtn" value="' + resp[i].registered_book_id + '" onclick="editButton()">edit</button>' + "</td>"
        str += "</tr>"
      });

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

    var jsonData = {"sellerId":"1", "category":val};

    getBooks("category.do", jsonData);
}

function searchButton() {
  var sel = document.getElementById("categorySelect");
  var val = sel.options[sel.selectedIndex].value;
  var keyword = document.getElementById("keyword").value;

  var jsonData = {"sellerId":"1", "category":val, "keyword":keyword};

  getBooks("keyword.do", jsonData);
}

function inputTextCheck() {
  var input = document.getElementById("keyword").value;

  if (input == '') {
    var sel = document.getElementById("categorySelect");
    var val = sel.options[sel.selectedIndex].value;

    var jsonData = {"sellerId":"1", "category":val};

    getBooks("category.do", jsonData);

  }
}

function salesButton() {
  var sel = document.getElementById("categorySelect");
  var val = sel.options[sel.selectedIndex].value;

  var jsonData = { "sellerId":"1", "category":val };

  $.ajax({
    url:"sales.do",
    type:"POST",
    data:JSON.stringify(jsonData),
    contentType: 'application/json; charset=UTF-8',
    dataType: 'json',
    success: function(resp) {
      var str = "";
      $("#maintable").children().remove();

      $.each(resp, function (i) {
        console.log(resp[i].image_url);
        str += "<tr>"
        str += "<td>" + '<img src="' + resp[i].image_url + '">' + "</td>"
        str += "<td>" + resp[i].title + "</td>"
        str += "<td>" + resp[i].order_count + "</td>"
        str += "<td>" + '<button type="button" name="editBtn" id="editBtn" value="' + resp[i].registered_book_id + '" onclick="editButton()">edit</button>' + "</td>"
        str += "</tr>"
      });

      $("#maintable").append(str);

    },
    error : function () {
      alert("error!");
    }

  });
}

function editButton() {
  var val = document.getElementById("editBtn").value;

  location.href = "/bookEdit.do?registeredBookId=" + val;

}

function updateButton() {

  var stock = document.getElementById("stock").value;
  var discount = document.getElementById("discount").value;
  var id = document.getElementById("updateBtn").value;

  var jsonData = {"stock":stock, "discount":discount, "id":id};

  $.ajax({
    url:"update.do",
    type:"POST",
    data:JSON.stringify(jsonData),
    contentType: "application/json; charset=UTF-8",

    success: function (result) {
      alert("sucess!");

      location.href = "/adminMain.do?sellerId=1";

    },
    error: function () {
      alert("error...");
    }
  });

}

function cancelButton() {
  location.href = "/adminMain.do?sellerId=1";
}
