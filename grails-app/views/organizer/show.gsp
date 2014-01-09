
<%@ page import="dk.roninit.loppadmin.Organizer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organizer.label', default: 'Organizer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-organizer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-organizer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list organizer">
			
				<g:if test="${organizerInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="organizer.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:fieldValue bean="${organizerInstance}" field="createdBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.modifiedBy}">
				<li class="fieldcontain">
					<span id="modifiedBy-label" class="property-label"><g:message code="organizer.modifiedBy.label" default="Modified By" /></span>
					
						<span class="property-value" aria-labelledby="modifiedBy-label"><g:fieldValue bean="${organizerInstance}" field="modifiedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="organizer.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${organizerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="organizer.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${organizerInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="property-label"><g:message code="organizer.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${organizerInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="organizer.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${organizerInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.enableBooking}">
				<li class="fieldcontain">
					<span id="enableBooking-label" class="property-label"><g:message code="organizer.enableBooking.label" default="Enable Booking" /></span>
					
						<span class="property-value" aria-labelledby="enableBooking-label"><g:formatBoolean boolean="${organizerInstance?.enableBooking}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="organizer.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${organizerInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${organizerInstance?.markedItem}">
				<li class="fieldcontain">
					<span id="markedItem-label" class="property-label"><g:message code="organizer.markedItem.label" default="Marked Item" /></span>
					
						<g:each in="${organizerInstance.markedItem}" var="m">
						<span class="property-value" aria-labelledby="markedItem-label"><g:link controller="coreMarkedItem" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:organizerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${organizerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
