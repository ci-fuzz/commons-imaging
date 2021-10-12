package fuzz_targets;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.awt.image.BufferedImage;

import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.formats.pnm.PnmImageParser;
import org.apache.commons.imaging.common.bytesource.ByteSourceArray;

public class PnmImageParserFuzzer {
	public static void fuzzerTestOneInput(byte[] input) {	
		try {
			PnmImageParser p = new PnmImageParser();
			BufferedImage image = p.getBufferedImage(new ByteSourceArray(input), new HashMap<>());
		} catch (IOException | ImageReadException e) {
			return;
		}
	}
}
