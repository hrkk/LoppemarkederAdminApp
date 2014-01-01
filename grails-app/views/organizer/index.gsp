
<%@ page import="dk.roninit.loppadmin.Organizer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organizer.label', default: 'Organizer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-organizer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-organizer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="createdBy" title="${message(code: 'organizer.createdBy.label', default: 'Created By')}" />
					
						<g:sortableColumn property="modifiedBy" title="${message(code: 'organizer.modifiedBy.label', default: 'Modified By')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'organizer.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'organizer.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'organizer.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="phone" title="${message(code: 'organizer.phone.label', default: 'Phone')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${organizerInstanceList}" status="i" var="organizerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${organizerInstance.id}">${fieldValue(bean: organizerInstance, field: "createdBy")}</g:link></td>
					
						<td>${fieldValue(bean: organizerInstance, field: "modifiedBy")}</td>
					
						<td>${fieldValue(bean: organizerInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: organizerInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: organizerInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: organizerInstance, field: "phone")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${organizerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
