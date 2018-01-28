<#include 'common/header.ftl'>

<div class="container text-primary text-center">
    <div class="jumbotron">
        <h1 class="">用户页面</h1>
        <p><a class="btn btn-primary btn-lg" role="button">
            学习更多</a>
        </p>

        <div id="App"></div>
    </div>
</div>

<script type="text/babel">
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
                return (<div> {JSON.stringify(it)} </div>)
            };

            var codeStyle = {
                fontSize: '2rem',
                overflow: 'overlay',
                textAlign: 'left'
            };

            return (
                    <div style={codeStyle}>{createItem(this.state.context)}</div>
            );
        }
    });

    ReactDOM.render(<SessionPage url="/api/session"/>, document.getElementById("App"));
</script>


<#include 'common/footer.ftl'>
