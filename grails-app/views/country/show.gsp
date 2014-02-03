
<%@ page import="dk.roninit.loppadmin.Country" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'country.label', default: 'Country')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-country" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-country" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list country">
			
				<g:if test="${countryInstance?.countryName}">
				<li class="fieldcontain">
					<span id="countryName-label" class="property-label"><g:message code="country.countryName.label" default="Country Name" /></span>
					
                        <span class="property-value" aria-labelledby="countryName-label"><g:fieldValue bean="${countryInstance}" field="countryName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${countryInstance?.countryCode}">
				<li class="fieldcontain">
					<span id="countryCode-label" class="property-label"><g:message code="country.countryCode.label" default="Country Code" /></span>
					
                        <span class="property-value" aria-labelledby="countryCode-label"><g:fieldValue bean="${countryInstance}" field="countryCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${countryInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="country.createdBy.label" default="Created By" /></span>
					
                        <span class="property-value" aria-labelledby="createdBy-label"><g:fieldValue bean="${countryInstance}" field="createdBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${countryInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="country.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${countryInstance?.dateCreated}" /></span>
                    
				</li>
				</g:if>
			
				<g:if test="${countryInstance?.modifiedBy}">
				<li class="fieldcontain">
					<span id="modifiedBy-label" class="property-label"><g:message code="country.modifiedBy.label" default="Modified By" /></span>
					
                        <span class="property-value" aria-labelledby="modifiedBy-label"><g:fieldValue bean="${countryInstance}" field="modifiedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${countryInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="country.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${countryInstance?.lastUpdated}" /></span>
                    
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:countryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${countryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
