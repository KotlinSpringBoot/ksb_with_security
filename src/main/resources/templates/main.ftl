<#include 'common/header.ftl'>

<div class="container text-primary text-center">
    <div class="jumbotron">
        <h1 class="">HTTP 接口测试</h1>

        <div id="httpTestApp"></div>
        <div id="App"></div>
    </div>
</div>

<script type="text/babel">
    var header = $("meta[name='_csrf.parameterName']").attr("content");
    var token = $("meta[name='_csrf.token']").attr("content");

    var SessionPage = React.createClass({

        getInitialState: function () {
            var context = {
                context: {}
            };
            return context;
        },

        componentDidMount: function () {
            this.serverRequest = $.ajax({
                url: this.props.url,
                data: {},
                type: 'GET',
                dataType: 'json',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                },
                success: function (data) {
                    this.setState({
                        context: data
                    })
                }.bind(this), // 修改bind()前的函数内部this变量指向。if 不bind的话，方法内部的this 就是 $.ajax({这个对象}), bind传入的this应该是组件。 可以console 输出一下看看。
                error: function (msg) {
                    console.log("error:" + msg);
                }.bind(this)
            })
        },

        componentWillUnmount: function () {
            this.serverRequest.abort()
        },


        render: function () {


            var createItem = function (it) {
                return (
                        <div> {JSON.stringify(it)}</div>
                )
            };

            var codeStyle = {
                overflow: 'overlay',
                textAlign: 'left'
            };

            return (
                    <div style={codeStyle}>当前用户 Session: {createItem(this.state.context)}</div>
            );
        }
    });

    ReactDOM.render(
            <SessionPage url="/api/session"/>
            , document.getElementById("App"));


    var HttpTestAppPage = React.createClass({
                getInitialState: function () {
                    var initialState = {
                        result: '',
                        url: '',
                        msg: '',
                        method: 'GET'
                    };
                    return initialState;
                },

                componentDidMount: function () {

                },

                componentWillUnmount: function () {
                },

                handleClick: function () {
                    $.ajax({
                        url: "/httpTest",
                        type: 'POST',
                        data: {url: this.state.url, method: this.state.method, postData: this.state.postData},
                        dataType: 'json',
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader('X-CSRF-TOKEN', token); // POST, header 'X-CSRF-TOKEN'
                        },
                        success: function (data) {
                            this.setState({
                                result: data.result,
                                msg: data.msg,
                            })
                        }.bind(this), // 修改bind()前的函数内部this变量指向。if 不bind的话，方法内部的this 就是 $.ajax({这个对象}), bind传入的this应该是组件。 可以console 输出一下看看。
                        error: function (msg) {
                            console.log("error:" + msg);
                        }.bind(this)
                    })
                },

                handleUrlChange: function (e) {
                    console.log('handleUrlChange')
                    console.dir(e)
                    this.setState({
                        url: e.target.value
                    })
                }
                ,

                handleMethodChange: function (e) {
                    console.log('handleMethodChange')
                    console.dir(e)
                    this.setState({
                        method: e.target.value
                    })
                }
                ,

                render: function () {

                    return (<div>
                                <table>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <button type="button"
                                                    className="btn btn-primary do-test-btn"
                                                    onClick={this.handleClick}>
                                                执行测试
                                            </button>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label>测试 URL:</label>
                                        </td>
                                        <td>
                                            <input type="text" onChange={this.handleUrlChange} className="col-sm-12"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>请求方法:</label>
                                        </td>
                                        <td>
                                            <select onChange={this.handleMethodChange} className="col-sm-12">
                                                <option value="GET">GET</option>
                                                <option value="POST">POST</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><label>响应输出：</label></td>
                                        <td>
                                        <textarea rows="30" cols="120" value={this.state.result}>
                                        </textarea>
                                        </td>
                                    </tr>
                                </table>
                                <div>{this.state.error}</div>
                            </div>
                    )
                }
            })
    ;


    ReactDOM.render(<HttpTestAppPage/>
            , document.getElementById("httpTestApp"));


</script>


<#include 'common/footer.ftl'>
