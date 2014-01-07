
<%@ page import="dk.roninit.loppadmin.MarkedItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'markedItem.label', default: 'MarkedItem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-markedItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-markedItem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'markedItem.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="address" title="${message(code: 'markedItem.address.label', default: 'Address')}" />
					
						<g:sortableColumn property="fromDate" title="${message(code: 'markedItem.fromDate.label', default: 'From Date')}" />
					
						<g:sortableColumn property="toDate" title="${message(code: 'markedItem.toDate.label', default: 'To Date')}" />
					
						<g:sortableColumn property="dateExtraInfo" title="${message(code: 'markedItem.dateExtraInfo.label', default: 'Date Extra Info')}" />
					
						<g:sortableColumn property="entreInfo" title="${message(code: 'markedItem.entreInfo.label', default: 'Entre Info')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${markedItemInstanceList}" status="i" var="markedItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${markedItemInstance.id}">${fieldValue(bean: markedItemInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "address")}</td>
					
						<td><g:formatDate date="${markedItemInstance.fromDate}" /></td>
					
						<td><g:formatDate date="${markedItemInstance.toDate}" /></td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "dateExtraInfo")}</td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "entreInfo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${markedItemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
