
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
					
						<g:sortableColumn property="createdBy" title="${message(code: 'dateInterval.createdBy.label', default: 'Created By')}" />
					
						<g:sortableColumn property="modifiedBy" title="${message(code: 'dateInterval.modifiedBy.label', default: 'Modified By')}" />
					
						<g:sortableColumn property="fromDate" title="${message(code: 'dateInterval.fromDate.label', default: 'From Date')}" />
					
						<g:sortableColumn property="toDate" title="${message(code: 'dateInterval.toDate.label', default: 'To Date')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'dateInterval.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'dateInterval.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dateIntervalInstanceList}" status="i" var="dateIntervalInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dateIntervalInstance.id}">${fieldValue(bean: dateIntervalInstance, field: "createdBy")}</g:link></td>
					
						<td>${fieldValue(bean: dateIntervalInstance, field: "modifiedBy")}</td>
					
						<td><g:formatDate date="${dateIntervalInstance.fromDate}" /></td>
					
						<td><g:formatDate date="${dateIntervalInstance.toDate}" /></td>
					
						<td><g:formatDate date="${dateIntervalInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${dateIntervalInstance.lastUpdated}" /></td>
					
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
