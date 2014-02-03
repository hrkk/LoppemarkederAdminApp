
<%@ page import="dk.roninit.loppadmin.DateInterval" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dateInterval.label', default: 'DateInterval')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-dateInterval" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-dateInterval" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dateInterval">
			
				<g:if test="${dateIntervalInstance?.fromDate}">
				<li class="fieldcontain">
					<span id="fromDate-label" class="property-label"><g:message code="dateInterval.fromDate.label" default="From Date" /></span>
					
						<span class="property-value" aria-labelledby="fromDate-label"><g:formatDate date="${dateIntervalInstance?.fromDate}" /></span>
                    
				</li>
				</g:if>
			
				<g:if test="${dateIntervalInstance?.toDate}">
				<li class="fieldcontain">
					<span id="toDate-label" class="property-label"><g:message code="dateInterval.toDate.label" default="To Date" /></span>
					
						<span class="property-value" aria-labelledby="toDate-label"><g:formatDate date="${dateIntervalInstance?.toDate}" /></span>
                    
				</li>
				</g:if>
			
				<g:if test="${dateIntervalInstance?.createdBy}">
				<li class="fieldcontain">
					<span id="createdBy-label" class="property-label"><g:message code="dateInterval.createdBy.label" default="Created By" /></span>
					
                        <span class="property-value" aria-labelledby="createdBy-label"><g:fieldValue bean="${dateIntervalInstance}" field="createdBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dateIntervalInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="dateInterval.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${dateIntervalInstance?.dateCreated}" /></span>
                    
				</li>
				</g:if>
			
				<g:if test="${dateIntervalInstance?.modifiedBy}">
				<li class="fieldcontain">
					<span id="modifiedBy-label" class="property-label"><g:message code="dateInterval.modifiedBy.label" default="Modified By" /></span>
					
                        <span class="property-value" aria-labelledby="modifiedBy-label"><g:fieldValue bean="${dateIntervalInstance}" field="modifiedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dateIntervalInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="dateInterval.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${dateIntervalInstance?.lastUpdated}" /></span>
                    
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:dateIntervalInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${dateIntervalInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
