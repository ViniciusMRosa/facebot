package co.aurasphere.facebot.event.postback;

import co.aurasphere.facebot.event.EventCallbackHandler;
import co.aurasphere.facebot.event.base.BaseStringEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * An {@link EventCallbackHandler} that processes all the incoming callbacks
 * that contains a specific postback payload from Facebook's Messenger Platform.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public abstract class PostbackEvent extends BaseStringEvent {

	/**
	 * @see BaseStringEvent#BaseEvent(String)
	 */
	public PostbackEvent(String expectedPayload, boolean caseSensitive) {
		super(expectedPayload, caseSensitive);
	}

	/**
	 * @return true if the postback payload received by the callback equals the
	 *         expected payload, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		if(!caseSensitive){
			expectedString = expectedString.toLowerCase();
			payload = payload.toLowerCase();
		}
		return payload.equals(expectedString);
	}

}