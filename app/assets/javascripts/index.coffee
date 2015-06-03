$ ->
  $.get "/GetPost", (data) ->
    $.each data, (index, Post) ->
      $("#GetPost").append $("<li>").text Post.post
