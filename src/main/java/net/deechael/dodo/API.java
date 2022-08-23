package net.deechael.dodo;

import net.deechael.dodo.annotation.*;
import net.deechael.dodo.network.Route;

public final class API {

    public static final String BASE_URL = "https://botopen.imdodo.com/api/v1/";

    private static final String POST = "POST";
    private static final String GET = "GET";

    private API() {
    }

    public static class V1 {

        public static class Bot {

            @NonParameters
            @Responses({
                    @Response(name = "clientId", type = String.class),
                    @Response(name = "dodoId", type = String.class),
                    @Response(name = "nickName", type = String.class),
                    @Response(name = "avatarUrl", type = String.class)
            })
            public static Route info() {
                return new Route("POST", "bot/info");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class)
            })
            @NonResponses
            public static Route leave() {
                return new Route("POST", "bot/leave");
            }

        }

        public static class Island {

            @NonParameters
            @PagedResponses({
                    @Response(name = "islandId", type = String.class),
                    @Response(name = "islandName", type = String.class),
                    @Response(name = "coverUrl", type = String.class),
                    @Response(name = "memberCount", type = int.class),
                    @Response(name = "onlineMemberCount", type = int.class),
                    @Response(name = "defaultChannelId", type = String.class),
                    @Response(name = "systemChannelId", type = String.class)
            })
            public static Route list() {
                return new Route("POST", "island/list");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class)
            })
            @Responses({
                    @Response(name = "islandId", type = String.class),
                    @Response(name = "islandName", type = String.class),
                    @Response(name = "coverUrl", type = String.class),
                    @Response(name = "memberCount", type = int.class),
                    @Response(name = "onlineMemberCount", type = int.class),
                    @Response(name = "defaultChannelId", type = String.class),
                    @Response(name = "systemChannelId", type = String.class)
            })
            public static Route info() {
                return new Route("POST", "island/info");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class)
            })
            @PagedResponses({
                    @Response(name = "dodoId", type = String.class),
                    @Response(name = "nickName", type = String.class),
                    @Response(name = "level", type = int.class),
                    @Response(name = "rank", type = int.class)
            })
            public static Route levelRankList() {
                return new Route("POST", "island/level/rank/list");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class),
                    @Parameter(name = "pageSize", type = int.class),
                    @Parameter(name = "maxId", type = long.class)
            })
            @Responses(
                    value = {
                            @Response(name = "maxId", type = Object.class)
                    },
                    extra = {
                            @ListItemResponse(name = "list",
                                    content = {
                                            @Response(name = "dodoId", type = String.class)
                                    })
                    }
            )
            public static Route muteList() {
                return new Route("POST", "island/mute/list");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class),
                    @Parameter(name = "pageSize", type = int.class),
                    @Parameter(name = "maxId", type = long.class)
            })
            @Responses(
                    value = {
                            @Response(name = "maxId", type = Object.class)
                    },
                    extra = {
                            @ListItemResponse(name = "list",
                                    content = {
                                            @Response(name = "dodoId", type = String.class)
                                    })
                    }
            )
            public static Route banList() {
                return new Route("POST", "island/ban/list");
            }

        }

        public static class Channel {

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class)
            })
            @PagedResponses({
                    @Response(name = "channelId", type = String.class),
                    @Response(name = "channelName", type = String.class),
                    @Response(name = "channelType", type = int.class),
                    @Response(name = "defaultFlag", type = int.class),
                    @Response(name = "groupId", type = String.class),
                    @Response(name = "groupName", type = String.class)
            })
            public static Route list() {
                return new Route("POST", "channel/list");
            }

            @RequiredParameters({
                    @Parameter(name = "channelId", type = String.class)
            })
            @PagedResponses({
                    @Response(name = "channelId", type = String.class),
                    @Response(name = "channelName", type = String.class),
                    @Response(name = "channelType", type = int.class),
                    @Response(name = "islandId", type = String.class),
                    @Response(name = "defaultFlag", type = int.class),
                    @Response(name = "groupId", type = String.class),
                    @Response(name = "groupName", type = String.class)
            })
            public static Route info() {
                return new Route("POST", "channel/info");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class),
                    @Parameter(name = "channelType", type = int.class, mustBe = "x in (1, 2, 4)")
            })
            @OptionalParameters({
                    @Parameter(name = "channelName", type = String.class)
            })
            @Responses({
                    @Response(name = "channelId", type = String.class),
            })
            public static Route add() {
                return new Route("POST", "channel/add");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class),
                    @Parameter(name = "channelId", type = String.class)
            })
            @OptionalParameters({
                    @Parameter(name = "channelName", type = String.class, mustBe = "x.length() <= 32")
            })
            @NonResponses
            public static Route edit() {
                return new Route("POST", "channel/edit");
            }

            @RequiredParameters({
                    @Parameter(name = "islandId", type = String.class),
                    @Parameter(name = "channelId", type = String.class)
            })
            @NonResponses
            public static Route remove() {
                return new Route("POST", "channel/remove");
            }

            @RequiredParameters({
                    @Parameter(name = "channelId", type = String.class),
                    @Parameter(name = "messageType", type = int.class, mustBe = "x in [1, 2, 3, 4, 6]"),
                    @Parameter(name = "messageBody", type = Object.class)
            })
            @OptionalParameters({
                    @Parameter(name = "referencedMessageId", type = String.class),
                    @Parameter(name = "dodoId", type = String.class)
            })
            @Responses({
                    @Response(name = "messageId", type = String.class),
            })
            public static Route messageSend() {
                return new Route("POST", "channel/message/send");
            }

            @RequiredParameters({
                    @Parameter(name = "messageId", type = String.class),
                    @Parameter(name = "messageType", type = int.class, mustBe = "x in [1, 6]"),
                    @Parameter(name = "messageBody", type = Object.class)
            })
            @Responses({
                    @Response(name = "messageId", type = String.class),
            })
            public static Route messageEdit() {
                return new Route("POST", "channel/message/edit");
            }

            @RequiredParameters({
                    @Parameter(name = "messageId", type = String.class),
                    @Parameter(name = "reason", type = String.class)
            })
            @NonResponses
            public static Route messageWithdraw() {
                return new Route("POST", "channel/message/withdraw");
            }

            @RequiredParameters({
                    @Parameter(name = "messageId", type = String.class),
                    @Parameter(name = "emoji", type = Object.class)
            })
            @NonResponses
            public static Route messageReactionAdd() {
                return new Route("POST", "channel/message/reaction/add");
            }

            @RequiredParameters({
                    @Parameter(name = "messageId", type = String.class),
                    @Parameter(name = "emoji", type = Object.class)
            })
            @OptionalParameters({
                    @Parameter(name = "dodoId", type = String.class)
            })
            @NonResponses
            public static Route messageReactionRemove() {
                return new Route("POST", "channel/message/reaction/remove");
            }

        }

        public static class Role {
            // TODO
        }

        public static class Member {
            // TODO
        }

        public static class Personal {
            // TODO
        }

        public static class Resource {
            // TODO
        }

        public static class Websocket {
            // TODO
        }

    }

}