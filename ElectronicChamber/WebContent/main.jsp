<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title> 
    <style>
        body
        {
            margin: 0;
            padding: 0;
            border: 0;
            overflow: hidden;
            height: 100%;
            max-height: 100%;
        }
 
        #frameTop
        {
            position: absolute;
            top: 0;
            left: 0;
            height: 100px;
            width: 100%;
            overflow: hidden;
            vertical-align: middle;
        }
 
        #frameContentLeft
        {
            position: fixed;
            top: 100px;
            left: 0;
            height: 100%;
            width: 150px;
            overflow: hidden;
            vertical-align: top;
            background-color: #D2E6FA;
        }
 
        #frameContentRight
        {
            position: absolute;
            left: 150px;
            top: 100px;
            height: 100%;
            width: 100%;
            right: 0;
            bottom: 0;
            overflow: hidden;
            background: #fff;
        }
    </style>

</head>
<body>
	<div>
        <iframe id="frameTop" src="top.jsp"></iframe>
    </div>
 
    <div>
        <iframe id="frameContentLeft" src="left.jsp"></iframe>
        <iframe id="frameContentRight" name="mainFrame" src="index.jsp"></iframe>
    </div>
</body>
</html>