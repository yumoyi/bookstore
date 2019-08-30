/**
 * 添加和修改商品时候验证
 */
function checkForm(){
		var nickName=document.getElementById("pname").value;
		if(nickName==null||nickName==""){
			document.getElementById("error1").innerHTML="商品名称不能为空！";
			return false;
		}
		return true;		
}