<HEAD><TITLE>输入法测试</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312"><!--  <LINK 
href="/favicon.ico" type=image/x-icon rel="shortcut icon">-->
<SCRIPT language=JavaScript src="./images/pinyin-jianti-table.js" 
type=text/javascript></SCRIPT>

<SCRIPT language=JavaScript src="./images/core.js" 
type=text/javascript></SCRIPT>

<STYLE type=text/css>BODY {
PADDING-RIGHT: 0px; PADDING-LEFT: 0px; FONT-SIZE: 16px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px
}
</STYLE>

<META content="MSHTML 6.00.2900.2769" name=GENERATOR></HEAD>
<BODY onload=on_load()>
<FORM style="FONT-SIZE: 100%" name=form1 action="return false" method=post>
　<p align="center"><b><font color="#008080" size="5"><span lang="zh-cn">
输入法测试</span></font></b><TEXTAREA onKeyPress="return key_press(event);" id=edit_area onKeyDown="return key_down(event);" onKeyUp="return key_up(event);" style="WIDTH: 100%; HEIGHT: 65%" name=edit_area rows=11 cols=60></TEXTAREA> 

</p>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=1>
<TBODY>
<TR>
<TD style="BACKGROUND-COLOR: #f0eff1" 
onclick=document.form1.edit_area.focus() width="30%">
<DIV id=code_field style="PADDING-LEFT: 2px; FONT-SIZE: 110%"></DIV></TD>
<TD onclick=document.form1.edit_area.focus() align=left><LABEL 
onclick=document.form1.edit_area.focus()><INPUT type=radio CHECKED 
name=ch_en_switch>汉字</LABEL> <LABEL 
onclick=document.form1.edit_area.focus()><INPUT onclick=clear_all(); 
type=radio name=ch_en_switch>英文</LABEL> <LABEL 
onclick=document.form1.edit_area.focus()>(<INPUT id=full_shape2 
type=checkbox name=full_shape>全角)</LABEL> </TD>
<TD onclick=document.form1.edit_area.focus() align=middle><INPUT id=copyAll onclick=highlight_copy(); type=button value=复制全文 name=select> 
</TD></TR>
<TR>
<TD colSpan=3>
<DIV id=list_area 
style="PADDING-RIGHT: 2px; PADDING-LEFT: 2px; FONT-SIZE: 110%; PADDING-BOTTOM: 2px; PADDING-TOP: 2px; BACKGROUND-COLOR: #f0eff1" 
onclick=document.form1.edit_area.focus()></DIV></TD></TR></TBODY></TABLE>
<DIV style="display:none"><SELECT id=select1 style="FONT-SIZE: 11pt" 
onchange=disp_fuhao(this) name=select1> <OPTION selected>各类符号</OPTION></SELECT> 
<BR><SELECT id=select2 style="FONT-SIZE: 11pt" onchange=bihua(this) 
name=select2> <OPTION selected>笔画查字</OPTION></SELECT> <INPUT id=diji 
onclick=document.form1.shanchu.disabled=!this.checked; type=checkbox 
name=diji>低级模式<BR><INPUT id=shanchu onClick="document.form1.edit_area.value=document.form1.edit_area.value.replace(/==/, '');document.form1.edit_area.focus();" type=button value="删除 == " name=shanchu> 
</DIV></FORM><!-- Start of StatCounter Code -->
<SCRIPT language=javascript type=text/javascript>
<!-- 
var sc_project=760998; 
var sc_partition=6; 
var sc_security="472e6e0d"; 
var sc_invisible=1; 
//-->
</SCRIPT>
<br />
<h1>注意：</h1>
<hr />
<ol>
	<li>这只是一个测试环境功能并不完善</li>
	<li>目前没有条件在纯无中文法环境下测试</li>
	<li>算法不够优化，初次页面加载量过大</li>
</ol>
<br />
<ul>
<li><a href="http://ljq1288.appspot.com/">harck by: Christian 'defei' Lee  李佳麒 </a></li>
<li><a href="http://ajaxime.chasen.org/">Ajax IME: Web-based Japanese Input Method</a></li>
</ul>

</BODY></HTML>