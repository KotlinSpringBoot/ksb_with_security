<#include 'common/header.ftl'>
<div class="container text-danger text-center">
    <div class="jumbotron">
        <h1>管理员页面</h1>

        <h2>HTTP 接口测试记录：</h2>
        <table id="http-test-record"></table>

        <h2>用户列表：</h2>
        <div id="user-list"></div>

    </div>
</div>
<script type="text/babel">
    var UserList = React.createClass({
        getInitialState: function () {
            return {
                users: [{
                    username: '',
                    roles: ''
                }]
            };
        },

        componentDidMount: function () {
            console.log("url = " + this.props.url)
            this.serverRequest = $.get(this.props.url, function (result) {
                console.log("result = ");
                console.log(result);
                this.setState({
                    users: result
                });
            }.bind(this));
        },

        componentWillUnmount: function () {
            this.serverRequest.abort();
        },

        render: function () {
            var createItem = function (u) {
                return (<h3 key={'li_' + u.id}> {u.username + ':' + JSON.stringify(u)}</h3>);
            };

            var userStyle = {
                fontSize: '2rem',
                overflow: 'overlay',
                textAlign: 'left'
            };

            return (<div style={userStyle}>
                        <ul>
                            {this.state.users.map(createItem)}
                        </ul>
                    </div>
            );
        }
    });
    ReactDOM.render(<UserList url="/api/users"/>, document.getElementById("user-list"))
</script>
<script>
    var App = {
        initBootstrapTable: function () {
            var columns = []
            columns.push(
                    {
                        title: "ID",
                        field: "id",
                        align: 'left',
                        valign: 'middle',
                        formatter: function (value, row, index) {
                            return value;
                        }
                    },
                    {
                        title: "Author",
                        field: "author",
                        align: 'left',
                        valign: 'middle',
                        formatter: function (value, row, index) {
                            return value;
                        }
                    },
                    {
                        title: "URL",
                        field: "url",
                        align: 'left',
                        valign: 'middle',
                        formatter: function (value, row, index) {
                            return value;
                        }
                    },
                    {
                        title: "METHOD",
                        field: "method",
                        align: 'left',
                        valign: 'middle',
                        formatter: function (value, row, index) {
                            return value;
                        }
                    },
                    {
                        title: "CreateTime",
                        field: "gmtCreate",
                        align: 'left',
                        valign: 'middle',
                        formatter: function (value, row, index) {
                            return value;
                        }
                    }
            )

            $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN'])
            var searchText = $('.search').find('input').val()
            $('#http-test-record').bootstrapTable({
                url: '/httptestrecord/findAll',
                sidePagination: "server",
                queryParamsType: 'pageNo,pageSize',
                method: 'get',
                striped: true,     //是否显示行间隔色
                cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,  //是否显示分页（*）
                paginationPreText: ' 上一页',
                paginationNextText: '下一页',
                search: true,
                searchText: searchText,
                searchAlign: 'right',
                searchOnEnterKey: false,
                trimOnSearch: true,
                pageNumber: 1,     //初始化加载第一页，默认第一页
                pageSize: 10,      //每页的记录行数（*）
                pageList: [10, 20, 50, 100, 200], // 可选的每页数据
                totalField: 'totalElements', // 所有记录 count
                dataField: 'content', //后端 json 对应的表格List数据的 key
                columns: columns,
                smartDisplay: true,
                queryParams: function (params) {
                    // 处理查询参数
                    return {
                        pageSize: params.pageSize,
                        pageNo: params.pageNumber - 1,
                        sortName: params.sortName,
                        sortOrder: params.sortOrder,
                        searchText: params.searchText,
                    }
                },
                responseHandler: function (response) {
                    console.log(response)
                    // 类似 Filter，处理响应数据；记得要返回 response
                    return response
                }
            })
        },

        init: function () {
            App.initBootstrapTable()
        }
    }
    $(App.init())
</script>

<#include 'common/footer.ftl'>
