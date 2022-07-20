
function searchButton() {
    var sel = document.getElementById("categorySelect");

    var data = {"sellerId":1, "category":sel};

    $.ajax({
      url:"category.do",
      type:"POST",
      data:JSON.stringify(data),
      contentType: 'application/json; charset=UTF-8',
      dataType: 'json',
      success: function(resp) {
        $.forEach()
      }

    });
}