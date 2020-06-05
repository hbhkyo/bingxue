<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--  user-scalable=no禁用其缩放（zooming）功能。这样禁用缩放功能后，用户只能滚动屏幕 -->
<!--  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> -->
<title>首页</title>
<link href="./resources/css/bootstrap.css" rel="stylesheet">
</head>
<!-- .container 类用于固定宽度并支持响应式布局的容器。  .container-fluid 类用于 100% 宽度，占据全部视口（viewport）的容器。  -->
<div class="container">
	<h1>
		h1标签<small>small标签</small>
	</h1>
	<p>
		Nullam quis risus eget urna mollis ornare vel eu leo
		<mark>highlight</mark>
		<strong>rendered as bold text</strong><em>rendered as italicized
			text</em>
		<del>This line of text is meant to be treated as deleted text.</del>
		<u>This line of text will render as underlined</u>
	</p>
	<p class="lead">.lead 类可以让段落突出显示</p>
	<p class="text-lowercase">Lowercased text.</p>
	<p class="text-uppercase">Uppercased text.</p>
	<p class="text-capitalize">Capitalized text.</p>
	<p class="text-left">Left aligned text.</p>
	<p class="text-center">Center aligned text.</p>
	<p class="text-right">Right aligned text.</p>
	<p class="text-justify">Justified text.</p>
	<p class="text-nowrap">No wrap text.</p>
	<address>
		<strong>Full Name</strong><br> <a href="">first.last@example.com</a>
	</address>
	<blockquote>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Integer posuere erat a ante.</p>
		<footer>
			Someone famous in <cite title="Source Title">Source Title</cite>
		</footer>
	</blockquote>
	<blockquote class="blockquote-reverse">
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Integer posuere erat a ante.</p>
		<footer>
			Someone famous in <cite title="Source Title">Source Title</cite>
		</footer>
	</blockquote>
	<ul class="list-unstyled">
		<li>Someone famous in</li>
		<li>Someone famous in</li>
		<li>
			<ul>
				<li class="list-unstyled">Someone famous in</li>
				<li class="list-unstyled">Someone famous in</li>
			</ul>
		</li>
	</ul>

	<ul class="list-inline">
		<li>Someone famous in</li>
		<li>Someone famous in</li>
	</ul>

	<dl>
		<dt>Description lists</dt>
		<dd>A description list is perfect for defining terms.</dd>
		<dt>Description lists</dt>
		<dd>
			For example,
			<code>&lt;section&gt;</code>
			should be wrapped as inline.
		</dd>
		<dd>
			To switch directories, type
			<kbd>cd</kbd>
			followed by the name of the directory.<br> To edit settings,
			press
			<kbd>
				<kbd>ctrl</kbd>
				+
				<kbd>,</kbd>
			</kbd>
		</dd>
	</dl>

	<dl class="dl-horizontal">
		<dt>Description lists</dt>
		<dd>
			<var>y</var>
			=
			<var>m</var>
			<var>x</var>
			+
			<var>b</var>
			<samp>This text is meant to be treated as sample output from a
				computer program.</samp>
		</dd>
		<dt>Description lists</dt>
		<dd>
			<pre>&lt;p&gt;Sample text here...&lt;/p&gt;</pre>
		</dd>
		<dd class="pre-scrollable">A description list is perfect for
			defining terms.A description list is perfect for defining termsA
			description list is perfect for defining termsA description list is
			perfect for defining termsA description list is perfect for defining
			terms</dd>
	</dl>


	<table
		class="table table-striped table-bordered table-hover table-condensed">
		<!-- .table-striped 类可以给 <tbody> 之内的每一行增加斑马条纹样式 -->
		<!-- .table-bordered 类为表格和其中的每个单元格增加边框-->
		<!-- .table-hover 类可以让 <tbody> 中的每一行对鼠标悬停状态作出响应-->
		<!-- .table-condensed 类可以让表格更加紧凑，单元格中的内补（padding）均会减半-->
		<tbody>
			<tr>
				<td class="active">...</td>
				<td class="success">...</td>
				<td class="warning">...</td>
				<td class="danger">...</td>
				<td class="info">...</td>
			</tr>
			<tr>
				<td>...</td>
				<td>...</td>
			</tr>
		</tbody>
	</table>

	<div class="table-responsive">
		<!-- 将任何 .table 元素包裹在 .table-responsive 元素内，即可创建响应式表格，其会在小屏幕设备上（小于768px）水平滚动。当屏幕大于 768px 宽度时，水平滚动条消失 -->
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<tbody>
				<tr>
					<td class="active">...</td>
					<td class="success">...</td>
					<td class="warning">...</td>
					<td class="danger">...</td>
					<td class="info">...</td>
				</tr>
				<tr>
					<td>...</td>
					<td>...</td>
				</tr>
			</tbody>
		</table>
	</div>

	<form>
		<div class="form-group">
			<label for="exampleInputEmail1">Email address</label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				placeholder="Email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="Password">
		</div>
		<div class="form-group">
			<label for="exampleInputFile">File input</label> <input type="file"
				id="exampleInputFile">
			<p class="help-block">Example block-level help text here.</p>
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> Check me out
			</label>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>

	<form class="form-inline">
		<div class="form-group">
			<label class="sr-only" for="exampleInputName2 ">Name</label> <input
				type="text" class="form-control sr-only" id="exampleInputName2"
				placeholder="Jane Doe">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">Email</label> <input type="email"
				class="form-control" id="exampleInputEmail2"
				placeholder="jane.doe@example.com">
		</div>
		<button type="submit" class="btn btn-default">Send invitation</button>
	</form>

	<form class="form-inline">
		<div class="form-group">
			<label class="sr-only" for="exampleInputAmount">Amount (in
				dollars)</label>
			<div class="input-group">
				<div class="input-group-addon">$</div>
				<input type="text" class="form-control" id="exampleInputAmount"
					placeholder="Amount">
				<div class="input-group-addon">.00</div>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Transfer cash</button>
	</form>

	<form class="form-horizontal">
		<div class="form-group has-success has-feedback">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="Email">
			</div>
		</div>
		<div class="form-group has-warning has-feedback">
			<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
		<div class="form-group has-error">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> Remember me
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign in</button>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<textarea class="form-control" rows="3" readonly></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="checkbox-inline"> <input type="checkbox"
				id="inlineCheckbox1" value="option1"> 1
			</label> <label class="checkbox-inline"> <input type="checkbox"
				id="inlineCheckbox2" value="option2"> 2
			</label> <label class="checkbox-inline"> <input type="checkbox"
				id="inlineCheckbox3" value="option3"> 3
			</label> <label class="radio-inline"> <input type="radio"
				name="inlineRadioOptions" id="inlineRadio1" value="option1">
				1
			</label> <label class="radio-inline"> <input type="radio"
				name="inlineRadioOptions" id="inlineRadio2" value="option2">
				2
			</label> <label class="radio-inline"> <input type="radio"
				name="inlineRadioOptions" id="inlineRadio3" value="option3">
				3
			</label>
		</div>
		<select multiple class="form-control">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select>
		<div class="form-group has-success has-feedback">
			<label class="control-label" for="inputSuccess2">Input with
				success</label> <input type="text" class="form-control" id="inputSuccess2"
				aria-describedby="inputSuccess2Status"> <span
				class="glyphicon glyphicon-ok form-control-feedback"
				aria-hidden="true"></span> <span id="inputSuccess2Status"
				class="sr-only">(success)</span>
		</div>

		<div class="form-group has-warning has-feedback">
			<label class="control-label">Input with warning</label> <input
				type="text" class="form-control"> <span
				class="glyphicon glyphicon-warning-sign form-control-feedback"
				aria-hidden="true"></span>
		</div>
		<div class="form-group has-error has-feedback">
			<label class="control-label">Input with error</label> <input
				type="text" class="form-control"> <span
				class="glyphicon glyphicon-remove form-control-feedback"></span>
		</div>



	</form>
	<!-- .btn-lg、.btn-sm 或 .btn-xs 就可以获得不同尺寸的按钮。 -->
	<button type="button" class="btn btn-default">（默认样式）Default</button>
	<button type="button" class="btn btn-primary">（首选项）Primary</button>
	<button type="button" class="btn btn-success">（成功）Success</button>
	<button type="button" class="btn btn-info">（一般信息）Info</button>
	<button type="button" class="btn btn-warning">（警告）Warning</button>
	<button type="button" class="btn btn-danger">（危险）Danger</button>
	<button type="button" class="btn btn-link">（链接）Link</button>
	<button type="button" class="btn btn-lg btn-primary"
		disabled="disabled">Primary button</button>
	<button type="button" class="btn btn-default btn-lg"
		disabled="disabled">Button</button>
	<a href="#" class="btn btn-primary btn-lg disabled" role="button">Primary
		link</a> <a href="#" class="btn btn-default btn-lg active btn-block"
		role="button">Link</a>
	<!-- 
<img src="./resources/image/google.jpeg" alt="..." class="img-rounded center-block">
<img src="./resources/image/google.jpeg" alt="..." class="img-circle center-block">
<img src="./resources/image/google.jpeg" alt="..." class="img-thumbnail center-block"> -->
	<p class="text-muted">...</p>
	<p class="text-primary">...</p>
	<p class="text-success">...</p>
	<p class="text-info">...</p>
	<p class="text-warning">...</p>
	<p class="text-danger">...</p>
	<p class="bg-primary">...</p>
	<p class="bg-success">...</p>
	<p class="bg-info">...</p>
	<p class="bg-warning">...</p>
	<p class="bg-danger">...</p>
	<button type="button" class="close" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<span class="caret"></span>
	<div class="show">...</div>
	<div class="hidden">...</div>

</div>

<script src="./resources/js/jquery-1.11.3.js"></script>
<script src="./resources/js/bootstrap.js"></script>
</html>