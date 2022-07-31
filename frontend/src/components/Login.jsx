import React from 'react';
// import store from './shared_login_components/store';
import { Provider } from 'react-redux';
import Signin from './login_components/login/signin';

class Login extends React.Component {
  render() {
    return (
        <Signin />
      // </Provider>
    );
  }
}

export default Login;
