import React from 'react';
import './login.scss';
import logo from '../../../assets/images/logo.png';
// import { connect } from 'react-redux';
// import { setUserAction } from '../../shared_login_components/store/actions/user.actions';
// import { Dispatch } from 'redux';
// import { RouteComponentProps } from 'react-router-dom';
// import { Tab, Tabs, TabList, TabPanel } from "react-tabs";
// import Paper from "@material-ui/core/Paper";
// import Tab from "@material-ui/core/Tab";
// import Tabs from "@material-ui/core/Tabs";
import Tab from '../TabComponent/Tabss'

// interface Props extends RouteComponentProps {
//     setUserType(username: string): void
// };

class Signin extends React.Component {
    state = {
        login: true,
        signUpForm: {
            name: "",
            email: "",
            password: ""
        },
        signInForm: {
            email: "",
            password: ""
        }
    };

    render() {
        return (
            <div className="login">
                <div className={`login__colored-container ${this.state.login ? 'login__colored-container--left' : 'login__colored-container--right'}`}></div>
                <div className={`login__welcome-back ${this.state.login ? 'login__welcome-back--active' : 'login__welcome-back--inactive'}`}>
                    <div className="login__welcome-back__logo-container">
                        <img className="login__welcome-back__logo-container--image" src={logo} alt="KhanaKhazana" />
                        KhanaKhazana
                    </div>
                    <div className="login__welcome-back__main-container">
                        <div className="login__welcome-back__main-container__text-container">
                            <span className="login__welcome-back__main-container__text-container--title">
                                Welcome Back!
                            </span>
                            <span className="login__welcome-back__main-container__text-container--secondary">
                                To keep ordering your food with us, please log in.
                            </span>
                        </div>
                        <div onClick={() => {
                            this.setState({
                                login: !this.state.login
                            });
                        }} className="login__welcome-back__main-container__button-container">
                            Sign In
                        </div>
                    </div>
                </div>
                <div className={`login__create-container ${this.state.login ? 'login__create-container--active' : 'login__create-container--inactive'}`}>
                    Create Account
                    <div className="login__create-container__social-container">
                        {/* <img className="login__create-container__social-container--facebook-icon" src={facebook} alt="" />
                        <img className="login__create-container__social-container--google-icon" src={google} alt="" />
                        <img className="login__create-container__social-container--linkedin-icon" src={linkedin} alt="" /> */}
                    </div>
                    <span className="login__create-container--info-text">Enter the below details for your registration</span>
                    <span className="login__create-container--info-text">Sign up as</span>

                    <Tab></Tab>
                    <div className="login__create-container__form-container">
                            <form className="login__create-container__form-container__form" onSubmit={(e) => {
                            e.preventDefault();
                            this.signUp();
                        }}>
                            <input
                                className="login__create-container__form-container__form--name"
                                type="text"
                                placeholder="Name"
                                value={this.state.signUpForm.name}
                                onChange={(value) => this.setState({
                                    signUpForm: {
                                        name: value.target.value,
                                        email: this.state.signUpForm.email,
                                        password: this.state.signUpForm.password
                                    }
                                })}
                                required />
                            <input
                                className="login__create-container__form-container__form--email"
                                type="email"
                                placeholder="Email"
                                value={this.state.signUpForm.email}
                                onChange={(value) => this.setState({
                                    signUpForm: {
                                        email: value.target.value,
                                        name: this.state.signUpForm.name,
                                        password: this.state.signUpForm.password
                                    }
                                })}
                                required />
                            <input
                                className="login__create-container__form-container__form--password"
                                type="password"
                                placeholder="Password"
                                value={this.state.signUpForm.password}
                                onChange={(value) => this.setState({
                                    signUpForm: {
                                        password: value.target.value,
                                        name: this.state.signUpForm.name,
                                        email: this.state.signUpForm.email
                                    }
                                })}
                                required />
                            <button
                                className="login__create-container__form-container__form--submit">
                                Sign Up
                            </button>
                        </form>
                    </div>
                </div>
                <div className={`login__login-container ${!this.state.login ? 'login__login-container--active' : 'login__login-container--inactive'}`}>
                    <div className="login__login-container__logo-container">
                        <img className="login__login-container__logo-container--image" src={logo} alt="KhanaKhazana" />
                        KhanaKhazana
                    </div>
                    <div className="login__login-container__main-container">
    
                        <span className="login__login-container__main-container--info-text">Enter your details for login</span>
                        <div className="login__login-container__main-container__form-container">
                            <form className="login__login-container__main-container__form-container__form" onSubmit={(e) => {
                                e.preventDefault();
                                this.signIn();
                            }}>
                                <input
                                    className="login__login-container__main-container__form-container__form--email"
                                    type="email"
                                    placeholder="Email"
                                    value={this.state.signInForm.email}
                                    onChange={(value) => this.setState({
                                        signInForm: {
                                            email: value.target.value,
                                            password: this.state.signInForm.password
                                        }
                                    })}
                                    required />
                                <input
                                    className="login__login-container__main-container__form-container__form--password"
                                    type="password"
                                    placeholder="Password"
                                    value={this.state.signInForm.password}
                                    onChange={(value) => this.setState({
                                        signInForm: {
                                            password: value.target.value,
                                            email: this.state.signInForm.email
                                        }
                                    })}
                                    required />
                                <button
                                    className="login__login-container__main-container__form-container__form--submit">
                                    Sign In
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div className={`login__hello-container ${!this.state.login ? 'login__hello-container--active' : 'login__hello-container--inactive'}`}>
                    <div className="login__welcome-back__main-container__text-container">
                        <span className="login__welcome-back__main-container__text-container--title">
                            Hello, stranger!
                            </span>
                        <span className="login__welcome-back__main-container__text-container--secondary">
                            Enter your personal details and start your own portfolio!
                        </span>
                    </div>
                    <div onClick={() => {
                        this.setState({
                            login: !this.state.login
                        });
                    }} className="login__welcome-back__main-container__button-container">
                        Sign Up
                    </div>
                </div>
            </div>
        );
    }

    signUp() {
        this.setState({
            signUpForm: {
                name: "",
                password: "",
                email: ""
            }
        });
    }

    signIn() {
        this.props.history.push("/https://edb6cbc5-920a-41ea-8166-fb27339e4365.mock.pstmn.io/login");
        this.props.setUserType(this.state.signInForm.email);
        this.setState({
            signInForm: {
                password: "",
                email: ""
            }
        });
    }
}

// function mapDispatchToProps(dispatch: Dispatch) {
//     return {
//         setUserType: (username: string) =>
//           dispatch(setUserAction({
//               username
//           }))
//     };
// }

export default Signin;