/*
 * generated by Xtext
 */
package de.itemis.jee7;

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;

import de.itemis.jee7.formatting.Jee7LinkingDiagnosticMessageProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class DslRuntimeModule extends de.itemis.jee7.AbstractDslRuntimeModule
{
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider()
	{
		return Jee7LinkingDiagnosticMessageProvider.class;
	}
}
