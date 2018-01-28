<#include 'common/header.ftl'>
<div class="container text-danger text-center">
    <div class="jumbotron">
        <h1>管理员页面</h1>
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
<#include 'common/footer.ftl'>
