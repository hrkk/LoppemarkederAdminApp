
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
					
						<g:sortableColumn property="additionalOpenTimePeriod" title="${message(code: 'markedItem.additionalOpenTimePeriod.label', default: 'Additional Open Time Period')}" />
					
						<g:sortableColumn property="entreInfo" title="${message(code: 'markedItem.entreInfo.label', default: 'Entre Info')}" />
					
						<g:sortableColumn property="markedRules" title="${message(code: 'markedItem.markedRules.label', default: 'Marked Rules')}" />
					
						<g:sortableColumn property="markedInformation" title="${message(code: 'markedItem.markedInformation.label', default: 'Marked Information')}" />
					
						<th><g:message code="markedItem.address.label" default="Address" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${markedItemInstanceList}" status="i" var="markedItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${markedItemInstance.id}">${fieldValue(bean: markedItemInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "additionalOpenTimePeriod")}</td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "entreInfo")}</td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "markedRules")}</td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "markedInformation")}</td>
					
						<td>${fieldValue(bean: markedItemInstance, field: "address")}</td>
					
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
