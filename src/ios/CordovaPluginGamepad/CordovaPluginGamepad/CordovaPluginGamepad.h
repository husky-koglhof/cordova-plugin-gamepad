#import <Foundation/Foundation.h>

#import <Cordova/CDVPlugin.h>

@interface CordovaPluginGamepad : CDVPlugin
{
@private
    NSMutableArray* gamepads;
    NSMutableDictionary* argument;
    double initialTimeMillis;
    CDVInvokedUrlCommand* gamepadConnectedCommand;
    CDVInvokedUrlCommand* gamepadDisconnectedCommand;
}

-(void)dealloc;
-(void)pluginInitialize;
-(void)dispose;

@end
