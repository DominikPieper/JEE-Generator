package generator

import java.io.File
import org.eclipse.xtend.core.XtendStandaloneSetup

class Generator {
	def static void main(String[] args) {
		System::setProperty("java.awt.headless", "true")
		XtendStandaloneSetup::doSetup
		val out = new File("website")
		out.generateFiles(
			new Index,
			new Download,
			new Features,
			new Kontakt,
			new AboutUs,
			new Documentation,
			new LegalNotice
		)
		println("Done.")
	}

	def static void generateFiles(File targetDir, Resource ... sites) {
		for (site : sites) {
			site.generateTo(targetDir)
		}
	}
}
