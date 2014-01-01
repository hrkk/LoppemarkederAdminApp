
<%@ page import="dk.roninit.loppadmin.MarkedItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'markedItem.label', default: 'MarkedItem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-markedItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-markedItem" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list markedItem">
			
				<g:if test="${markedItemInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="markedItem.createdBy.label" default="Created By" /></span>
					
						<span class="property-value" aria-labelledby="createdBy-label"><g:fieldValue bean="${markedItemInstance}" field="createdBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.modifiedBy}">
				<li class="fieldcontain">
					<span id="modifiedBy-label" class="property-label"><g:message code="markedItem.modifiedBy.label" default="Modified By" /></span>
					
						<span class="property-value" aria-labelledby="modifiedBy-label"><g:fieldValue bean="${markedItemInstance}" field="modifiedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="markedItem.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${markedItemInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.additionalOpenTimePeriod}">
				<li class="fieldcontain">
					<span id="additionalOpenTimePeriod-label" class="property-label"><g:message code="markedItem.additionalOpenTimePeriod.label" default="Additional Open Time Period" /></span>
					
						<span class="property-value" aria-labelledby="additionalOpenTimePeriod-label"><g:fieldValue bean="${markedItemInstance}" field="additionalOpenTimePeriod"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.entreInfo}">
				<li class="fieldcontain">
					<span id="entreInfo-label" class="property-label"><g:message code="markedItem.entreInfo.label" default="Entre Info" /></span>
					
						<span class="property-value" aria-labelledby="entreInfo-label"><g:fieldValue bean="${markedItemInstance}" field="entreInfo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.markedRules}">
				<li class="fieldcontain">
					<span id="markedRules-label" class="property-label"><g:message code="markedItem.markedRules.label" default="Marked Rules" /></span>
					
						<span class="property-value" aria-labelledby="markedRules-label"><g:fieldValue bean="${markedItemInstance}" field="markedRules"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.markedInformation}">
				<li class="fieldcontain">
					<span id="markedInformation-label" class="property-label"><g:message code="markedItem.markedInformation.label" default="Marked Information" /></span>
					
						<span class="property-value" aria-labelledby="markedInformation-label"><g:fieldValue bean="${markedItemInstance}" field="markedInformation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="markedItem.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${markedItemInstance?.address?.id}">${markedItemInstance?.address?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="markedItem.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${markedItemInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.dateInterval}">
				<li class="fieldcontain">
					<span id="dateInterval-label" class="property-label"><g:message code="markedItem.dateInterval.label" default="Date Interval" /></span>
					
						<g:each in="${markedItemInstance.dateInterval}" var="d">
						<span class="property-value" aria-labelledby="dateInterval-label"><g:link controller="dateInterval" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="markedItem.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${markedItemInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.organizer}">
				<li class="fieldcontain">
					<span id="organizer-label" class="property-label"><g:message code="markedItem.organizer.label" default="Organizer" /></span>
					
						<span class="property-value" aria-labelledby="organizer-label"><g:link controller="organizer" action="show" id="${markedItemInstance?.organizer?.id}">${markedItemInstance?.organizer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:markedItemInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${markedItemInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
