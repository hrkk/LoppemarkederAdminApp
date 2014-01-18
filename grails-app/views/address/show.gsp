
<%@ page import="dk.roninit.loppadmin.Address" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-address" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list address">
			
				<g:if test="${addressInstance?.addressLine1}">
				<li class="fieldcontain">
					<span id="addressLine1-label" class="property-label"><g:message code="address.addressLine1.label" default="Address Line1" /></span>
					
                        <span class="property-value" aria-labelledby="addressLine1-label"><g:fieldValue bean="${addressInstance}" field="addressLine1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.addressLine2}">
				<li class="fieldcontain">
					<span id="addressLine2-label" class="property-label"><g:message code="address.addressLine2.label" default="Address Line2" /></span>
					
                        <span class="property-value" aria-labelledby="addressLine2-label"><g:fieldValue bean="${addressInstance}" field="addressLine2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.addressLine3}">
				<li class="fieldcontain">
					<span id="addressLine3-label" class="property-label"><g:message code="address.addressLine3.label" default="Address Line3" /></span>
					
                        <span class="property-value" aria-labelledby="addressLine3-label"><g:fieldValue bean="${addressInstance}" field="addressLine3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="address.latitude.label" default="Latitude" /></span>
					
                        <span class="property-value" aria-labelledby="latitude-label"><g:formatNumber number="${addressInstance?.latitude}" type="number" maxFractionDigits="9" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="address.longitude.label" default="Longitude" /></span>
					
                        <span class="property-value" aria-labelledby="longitude-label"><g:formatNumber number="${addressInstance?.longitude}" type="number" maxFractionDigits="9" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.postalCode}">
				<li class="fieldcontain">
					<span id="postalCode-label" class="property-label"><g:message code="address.postalCode.label" default="Postal Code" /></span>
					
                        <span class="property-value" aria-labelledby="postalCode-label"><g:fieldValue bean="${addressInstance}" field="postalCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.postalArea}">
				<li class="fieldcontain">
					<span id="postalArea-label" class="property-label"><g:message code="address.postalArea.label" default="Postal Area" /></span>
					
                        <span class="property-value" aria-labelledby="postalArea-label"><g:fieldValue bean="${addressInstance}" field="postalArea"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.markeditems}">
				<li class="fieldcontain">
					<span id="markeditems-label" class="property-label"><g:message code="address.markeditems.label" default="Markeditems" /></span>
					
						<g:each in="${addressInstance.markeditems}" var="m">
						<span class="property-value" aria-labelledby="markeditems-label"><g:link controller="coreMarkedItem" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.country}">
				<li class="fieldcontain">
					<span id="country-label" class="property-label"><g:message code="address.country.label" default="Country" /></span>
					
						<span class="property-value" aria-labelledby="country-label"><g:link controller="country" action="show" id="${addressInstance?.country?.id}">${addressInstance?.country?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="address.createdBy.label" default="Created By" /></span>
					
                        <span class="property-value" aria-labelledby="createdBy-label"><g:fieldValue bean="${addressInstance}" field="createdBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="address.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${addressInstance?.dateCreated}" /></span>
                    
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.modifiedBy}">
				<li class="fieldcontain">
					<span id="modifiedBy-label" class="property-label"><g:message code="address.modifiedBy.label" default="Modified By" /></span>
					
                        <span class="property-value" aria-labelledby="modifiedBy-label"><g:fieldValue bean="${addressInstance}" field="modifiedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="address.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${addressInstance?.lastUpdated}" /></span>
                    
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:addressInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${addressInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>