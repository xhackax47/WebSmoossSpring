package com.aplose.smooss.factory;

import com.aplose.smooss.model.BringModule;
import com.aplose.smooss.model.CarPoolingModule;
import com.aplose.smooss.model.ChatModule;
import com.aplose.smooss.model.MiniGameModule;
import com.aplose.smooss.model.Module;
import com.aplose.smooss.model.Module.TypeModule;
import com.aplose.smooss.model.PicturesModule;
import com.aplose.smooss.model.PlaylistModule;
import com.aplose.smooss.model.TriCountModule;

/**
 * This class allows to create a module with a corresponding type
 * @author Flavien
 * @author Rachid
 */
public class FactoryModule {
	
	/**
	 * @param type
	 * @return module
	 */
	public Module createModule(TypeModule type) {
		Module module = null;

		switch (type) {
			case CarpoolingModule:
				module = new CarPoolingModule();
				module.setType(type);
				break;
			case BringModule:
				module = new BringModule();
				module.setType(type);
				break;
			case PicturesModule:
				module = new PicturesModule();
				module.setType(type);
				break;
			case TriCountModule:
				module = new TriCountModule();
				module.setType(type);
				break;
			case MiniGameModule:
				module = new MiniGameModule();
				module.setType(type);
				break;
			case ChatModule:
				module = new ChatModule();
				module.setType(type);
				break;
			case PlaylistModule:
				module = new PlaylistModule();
				module.setType(type);
				break;
		}
		return module;
	}

}
