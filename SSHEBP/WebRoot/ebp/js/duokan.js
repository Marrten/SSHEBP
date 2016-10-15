// 1>书籍分类选项卡
$("#banner_menu_wrap").children().hover(function(){
	// alert("111");
    $(this).css("background","#ff6700");
    $(this).children(".banner_menu_content").css("border","1px solid #F0F0F0").show();
},function(){
    $(this).css("background","none");
    $(this).children(".banner_menu_content").css("border","0px solid #F0F0F0").hide();
});

// 2>主导航栏切换效果
$('.center-nav').children().click(function () {
    $(this).addClass('checked');
    $(this).siblings().removeClass('checked');
});

//立即购买
function buyAtOnce(book_id,user_id) {
	window.location.href = "ebp/Shopping.action?book_id="
			+ book_id;
}

//加入购物车
function addBook(book_id){
	var param = "book_id=" + book_id;
	$.ajax({   //json对象
		url: "ServletJsp/ShoppingCartServlet.jsp",
		data: param,
		dataType: "json",
		type: "get",
		success: successful,
		async: true,
		cache: false
	});
	
	function successful(data){
		alert(data.name+"成功加入购物车");
	}
}

