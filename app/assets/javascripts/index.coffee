$ ->
  $.get "/GetPost", (data) ->
    $.each data, (index, post) ->
      $("#post").append "<li> " +post.post+"<br>Username : "+post.user+"      "+"       Date : "+post.date+"</li>"
