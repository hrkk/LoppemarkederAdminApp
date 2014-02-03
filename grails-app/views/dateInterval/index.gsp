
<%@ page import="dk.roninit.loppadmin.DateInterval" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dateInterval.label', default: 'DateInterval')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dateInterval" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dateInterval" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="fromDate" title="${message(code: 'dateInterval.fromDate.label', default: 'From Date')}" />
					
						<g:sortableColumn property="toDate" title="${message(code: 'dateInterval.toDate.label', default: 'To Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dateIntervalInstanceList}" status="i" var="dateIntervalInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dateIntervalInstance.id}">${fieldValue(bean: dateIntervalInstance, field: "fromDate")}</g:link></td>
					
						<td><g:formatDate date="${dateIntervalInstance.toDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dateIntervalInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>