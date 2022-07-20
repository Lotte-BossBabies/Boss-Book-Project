
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
        str += "<td>" + "<button type='button' onclick='editButton()'>edit</button>" + "</td>"
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

function editButton() {
  var val = document.getElementById("editBtn").value;


}

