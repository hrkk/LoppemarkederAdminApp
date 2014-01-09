
<%@ page import="dk.roninit.loppadmin.CoreMarkedItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'coreMarkedItem.label', default: 'CoreMarkedItem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-coreMarkedItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-coreMarkedItem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="createdBy" title="${message(code: 'coreMarkedItem.createdBy.label', default: 'Created By')}" />
					
						<g:sortableColumn property="modifiedBy" title="${message(code: 'coreMarkedItem.modifiedBy.label', default: 'Modified By')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'coreMarkedItem.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="additionalOpenTimePeriod" title="${message(code: 'coreMarkedItem.additionalOpenTimePeriod.label', default: 'Additional Open Time Period')}" />
					
						<g:sortableColumn property="entreInfo" title="${message(code: 'coreMarkedItem.entreInfo.label', default: 'Entre Info')}" />
					
						<g:sortableColumn property="markedRules" title="${message(code: 'coreMarkedItem.markedRules.label', default: 'Marked Rules')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${coreMarkedItemInstanceList}" status="i" var="coreMarkedItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${coreMarkedItemInstance.id}">${fieldValue(bean: coreMarkedItemInstance, field: "createdBy")}</g:link></td>
					
						<td>${fieldValue(bean: coreMarkedItemInstance, field: "modifiedBy")}</td>
					
						<td>${fieldValue(bean: coreMarkedItemInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: coreMarkedItemInstance, field: "additionalOpenTimePeriod")}</td>
					
						<td>${fieldValue(bean: coreMarkedItemInstance, field: "entreInfo")}</td>
					
						<td>${fieldValue(bean: coreMarkedItemInstance, field: "markedRules")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${coreMarkedItemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
