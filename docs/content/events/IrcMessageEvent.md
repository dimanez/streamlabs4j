+++
title="IRC Message"
weight = 200
+++

# ChannelMessageEvent

## Description

The irc message received before it gets parsed and the real event gets dispatched.

## Dependencies

Requires the TwitchChat Module to be enabled and active for the source channel. See [TwitchChat](../chat).

## Examples

### Printing the Raw Message

```java
eventManager.onEvent(IRCMessageEvent.class).subscribe(event -> {
	System.out.println(event.getRawMessage());
});
```
