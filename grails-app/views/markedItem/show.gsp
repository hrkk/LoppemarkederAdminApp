
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
			
				<g:if test="${markedItemInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="markedItem.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${markedItemInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="markedItem.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${markedItemInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.fromDate}">
				<li class="fieldcontain">
					<span id="fromDate-label" class="property-label"><g:message code="markedItem.fromDate.label" default="From Date" /></span>
					
						<span class="property-value" aria-labelledby="fromDate-label"><g:formatDate date="${markedItemInstance?.fromDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.toDate}">
				<li class="fieldcontain">
					<span id="toDate-label" class="property-label"><g:message code="markedItem.toDate.label" default="To Date" /></span>
					
						<span class="property-value" aria-labelledby="toDate-label"><g:formatDate date="${markedItemInstance?.toDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.dateExtraInfo}">
				<li class="fieldcontain">
					<span id="dateExtraInfo-label" class="property-label"><g:message code="markedItem.dateExtraInfo.label" default="Date Extra Info" /></span>
					
						<span class="property-value" aria-labelledby="dateExtraInfo-label"><g:fieldValue bean="${markedItemInstance}" field="dateExtraInfo"/></span>
					
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
			
				<g:if test="${markedItemInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="markedItem.latitude.label" default="Latitude" /></span>
					
						<span class="property-value" aria-labelledby="latitude-label"><g:fieldValue bean="${markedItemInstance}" field="latitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${markedItemInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="markedItem.longitude.label" default="Longitude" /></span>
					
						<span class="property-value" aria-labelledby="longitude-label"><g:fieldValue bean="${markedItemInstance}" field="longitude"/></span>
					
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
