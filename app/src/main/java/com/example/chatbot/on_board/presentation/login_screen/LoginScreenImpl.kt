package com.example.chatbot.on_board.presentation.login_screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.chatbot.R
import com.example.chatbot.common.ui.util.SnackbarEvent
import com.example.chatbot.common.ui.util.TextFieldState
import com.example.chatbot.common.ui.util.UIState
import com.example.chatbot.common.ui.theme.Typography
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.foundation.layout.Arrangement



object LoginScreenImpl:LoginScreen() {

    @Composable
    fun NormalTextComponent(value: String){
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth(), // To occupy the entire width
            style = TextStyle(
                fontSize = 13.sp,
                fontStyle = FontStyle.Normal
            ),
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
    @Composable
    fun HeadingTextComponent(value: String){
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth() // To occupy the entire width
                .padding(10.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun LoginCard(modifier: Modifier,
                  emailState: StateFlow<TextFieldState>,
                  onEmailChanged: (String) -> Unit,
                  passwordState: StateFlow<TextFieldState>,
                  onPasswordChanged: (String) -> Unit,
                  onForgotPasswordClick: () -> Unit,
                  buttonLoginState: StateFlow<UIState>,
                  onButtonLoginClick: () -> Unit,
                  onRegister: () -> Unit){
        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f),
            colors = CardDefaults.cardColors(containerColor = Color(0xAA143D7A)),
            border = BorderStroke(0.7f.dp, color = Color(0xFF39ECF8))
        ) {
            Column(

            ){ Spacer(modifier = Modifier.height(8.dp))

                NormalTextComponent(value = stringResource(id = R.string.hey))
                HeadingTextComponent(value = stringResource(id = R.string.login_into_acc))
                Spacer(modifier = Modifier.height(50.dp))
                EmailTextField(
                    modifier = Modifier.fillMaxWidth(),
                    state = emailState,
                    onValueChanged = onEmailChanged
                )
                Spacer(modifier = Modifier.height(20.dp))
                PasswordTextField(
                    Modifier.fillMaxWidth().wrapContentWidth(),
                    state = passwordState,
                    onValueChanged = onPasswordChanged
                )
                Spacer(modifier = Modifier.height(8.dp))
                ForgotPasswordButton(
                    Modifier.fillMaxWidth().wrapContentWidth(),
                    onClick = onForgotPasswordClick
                )
                Spacer(modifier = Modifier.height(50.dp))
                LoginButton(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    state = buttonLoginState
                ) {
                    onButtonLoginClick()
                }
                RegisterButton(modifier = Modifier.fillMaxWidth().wrapContentHeight(), onClick = onRegister)
            }  }
    }

    @Composable
    override fun Main(viewModel: LoginScreenViewModel, onLoginCompleted: (String) -> Unit, onRegister: () -> Unit) {

        val snackbarHostState = SnackbarHostState()

        //Collecting the latest snackbar event
        //Initialised with null value
        val currentEvent by viewModel.snackbarChannel.collectAsState(null)

        // remember { mutableStateOf( 'Anything you want here ') } is used to tell  Jetpack Compose that you must 'Recompose' / re-draw everything that depends on this variable
        //in this case it will show / hide the dialog for the password reset
        var showForgotPasswordDialog by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds // Adjust this based on your image requirements
            )

            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                containerColor = Color.Transparent,
                snackbarHost = {
                    currentEvent?.let { event ->
                        //?.let means that will be executed only if the val is not null
                        // a more elegant way to handle the case if the val can be null
                        SnackbarHost(snackbarHostState) {
                            when (event.eventType) {
                                //here we change the color of the snackbar based on the event type
                                SnackbarEvent.EventType.Error -> {
                                    Snackbar(
                                        modifier = Modifier,
                                        containerColor = MaterialTheme.colorScheme.errorContainer,
                                        contentColor = MaterialTheme.colorScheme.onErrorContainer,
                                        snackbarData = it
                                    )
                                }

                                SnackbarEvent.EventType.Popup -> {
                                    Snackbar(
                                        modifier = Modifier,
                                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                        snackbarData = it
                                    )
                                }

                                SnackbarEvent.EventType.Confirmation -> {
                                    Snackbar(
                                        modifier = Modifier,
                                        containerColor = Color.Green,
                                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                        snackbarData = it
                                    )
                                }
                            }
                        }
                    }
                },
                contentColor = MaterialTheme.colorScheme.onBackground,
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(it).padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom)
                ) {
                    Headline()
                    LoginCard(modifier = Modifier,
                        emailState = viewModel.emailState,
                        onEmailChanged = viewModel :: onEmailChanged,
                        onPasswordChanged = viewModel :: onPasswordChanged,
                        onForgotPasswordClick = {
                                                showForgotPasswordDialog = true
                        },
                        buttonLoginState = viewModel.loginBtnState,
                        passwordState = viewModel.passwordState,
                        onRegister = onRegister,
                        onButtonLoginClick = {
                            viewModel.onLoginIsPressed(onLoginCompleted)
                        }
                        )
                }
            }

            if (showForgotPasswordDialog) {
                ForgotPasswordDialog(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    emailFieldState = viewModel.passwordResetEmailField,
                    sendResetPasswordEmailButtonState = viewModel.passwordResetButton,
                    onDismiss = {
                        //onDismiss is called when the dialog closes
                        showForgotPasswordDialog = false
                    },
                    onEmailChanged = viewModel::onResetPasswordEmaiLChanged,
                    onSendEmail = {
                        viewModel.sendPasswordResetEmail() {
                            //if a function is given as last argument you can use this syntax
                            //after the task is completed we close the dialogue
                            showForgotPasswordDialog = false
                        }
                    })
            }
            //Launch effect will trigger a coroutine that is triggered whenever the argument you provide has changed
            LaunchedEffect(currentEvent) {
                //whenever currentEvent changes , we check it the event is not null
                if (currentEvent != null) {
                    //if event is not null show the snackbar
                    snackbarHostState.showSnackbar(message = currentEvent!!.message)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun EmailTextField(
        modifier: Modifier,
        state: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit
    ) {
        val currentState by state.collectAsState()
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            OutlinedTextField(
                value = currentState.content,
                onValueChange = onValueChanged,
                modifier = Modifier.fillMaxWidth().width(20.dp),
                isError = currentState.state.isError(),
                enabled = !currentState.state.isLoading(),
                label = { Text("Email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.blue),
                    unfocusedBorderColor = colorResource(id = R.color.blue)
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = null) },
                trailingIcon = {
                    AnimatedVisibility(currentState.state.isCompleted()) {
                        //Animates and displays what's inside the block when the boolean is true
                        //Show a checkmark when the email is correct
                        Icon(Icons.Filled.Check, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    }
                    AnimatedVisibility(currentState.state.isError()) {
                        Icon(Icons.Filled.Warning, contentDescription = null)
                    }
                }
            )
            AnimatedVisibility(currentState.errorCode != null) {
                //show a text whenever the error code is not null
                //Animate the entrance and exit of the error
                currentState.errorCode?.let {
                    Text(stringResource(it), color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun PasswordTextField(
        modifier: Modifier,
        state: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit
    ) {
        val currentState by state.collectAsState() // collecting the latest state
        var passwordIsHidden by remember { mutableStateOf(true) } // a switch to determine when the password is visible


        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            OutlinedTextField(
                value = currentState.content,
                onValueChange = onValueChanged,
                modifier = Modifier.fillMaxWidth().width(20.dp),
                isError = currentState.state.isError(),
                enabled = !currentState.state.isLoading(),
                visualTransformation = if (passwordIsHidden)  VisualTransformation.None else PasswordVisualTransformation(),  // to show ****** when is hidden else tghe content
                label = { Text("Password") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.blue),
                    unfocusedBorderColor = colorResource(id = R.color.blue)
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null, ) },
                trailingIcon = {
                    AnimatedVisibility(passwordIsHidden && !currentState.state.isCompleted()) {
                        //Animates and displays what's inside the block when the boolean is true
                        Icon(Icons.Filled.Visibility, contentDescription = null, modifier = Modifier.clickable { passwordIsHidden = false })
                    }
                    AnimatedVisibility(!passwordIsHidden) {
                        Icon(Icons.Filled.VisibilityOff, contentDescription = null,modifier = Modifier.clickable { passwordIsHidden = true })
                    }
                    AnimatedVisibility(currentState.state.isCompleted()) {
                        Icon(Icons.Filled.Check, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    }
                }
            )
            AnimatedVisibility(currentState.errorCode != null) {
                //show a text whenever the error code is not null
                //Animate the entrance and exit of the error
                currentState.errorCode?.let {
                    Text(stringResource(it), color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }

    @Composable
    override fun LoginButton(modifier: Modifier, state: StateFlow<UIState>, onClick: () -> Unit) {
        val state by state.collectAsState()
        val containerColor by animateColorAsState(
            when {
                state.isCompleted() -> Color.Green
                state.isError() -> MaterialTheme.colorScheme.errorContainer
                else -> MaterialTheme.colorScheme.primaryContainer
            }, label = ""
        ) // Animate the container color based on state

        val contentColor by animateColorAsState(
            when {
                state.isCompleted() -> Color.White
                state.isError() -> MaterialTheme.colorScheme.onErrorContainer
                else -> MaterialTheme.colorScheme.onPrimaryContainer
            }, label = ""
        ) // Animate the content color based on state

        Button(onClick = {
            if (!state.isLoading()) {
                onClick()
            }// with these we prevent the user from triggering the login when the task is already being processed
        }, modifier = modifier, colors = ButtonDefaults.buttonColors(containerColor, contentColor)) {
            AnimatedContent(
                state,
                label = ""
            ) { state -> // with these we update the content of the button based on it's state
                when (state) {
                    UIState.Error -> {
                        Row(
                            modifier = Modifier.wrapContentSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Retry")
                            Icon(imageVector = Icons.Filled.Refresh, contentDescription = null)
                        }
                    }

                    UIState.Loading -> {
                        LinearProgressIndicator(modifier = Modifier.fillMaxWidth().height(2.dp))
                        //Be creative
                        //TODO::Come up with interesting animations for loading
                    }

                    UIState.Completed -> {
                        Row(
                            modifier = Modifier.wrapContentSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("Logged In!")
                            Icon(imageVector = Icons.Filled.Check, contentDescription = null)
                        }
                    }

                    else -> {
                        //We don't care about the other states
                        Row(
                            modifier = Modifier.wrapContentSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("Login Now!")
                            Icon(imageVector = Icons.Filled.Login, contentDescription = null)
                        }
                    }
                }
            }
        }
    }

    @Composable
    override fun Headline() {
        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = null
            )
        }
    }

    @Composable
    override fun ForgotPasswordButton(modifier: Modifier, onClick: () -> Unit) {
        Text(
            text = "Forgot Password",
            color = Color.White,
            modifier = Modifier.clickable { onClick() })
    }

    @Composable
    override fun ForgotPasswordDialog(
        modifier: Modifier,
        onDismiss: () -> Unit,
        emailFieldState: StateFlow<TextFieldState>,
        sendResetPasswordEmailButtonState: StateFlow<UIState>,
        onEmailChanged: (String) -> Unit,
        onSendEmail: () -> Unit
    ) {
        val textFieldState by emailFieldState.collectAsState()
        val btnState by sendResetPasswordEmailButtonState.collectAsState()

        Dialog(
            onDismissRequest = onDismiss,//you have to use this method to signal Compose to close the dialog
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .background(MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.wrapContentSize().padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Bottom)
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = null)
                    }
                    Text("Forgot Password?", style = Typography.headlineSmall)
                    Text("An Email will be sent in no time")


                    EmailTextField(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        emailFieldState,
                        onValueChanged = onEmailChanged
                    )

                    ForgotPasswordDialogButton(modifier = Modifier.fillMaxWidth().wrapContentHeight(), onClick = {
                        if (!btnState.isLoading()) onSendEmail()
                    })
                }
            }
        }
    }

    @Composable
    override fun ForgotPasswordDialogButton(modifier: Modifier, onClick: () -> Unit) {
        val interactionSource =
            remember { MutableInteractionSource() } // a class that collect user click events like when the button is pressed / Released
        val isPressedState by interactionSource.collectIsPressedAsState() // creating a variable that changes when the user presses
        // the animation is triggerred by the click event
        // when is clicked these animation will be trigerred
        //when the scale anim is finished the click method will be called
        val scale by animateFloatAsState(
            targetValue = if (isPressedState) 1.0f else 0.95f,
            finishedListener = { onClick() }, label = ""
        )
        val containerColor by animateColorAsState(
            targetValue = when (isPressedState) {
                true -> MaterialTheme.colorScheme.primary
                false -> MaterialTheme.colorScheme.surfaceContainer
            }, label = ""
        )
        val contentColor by animateColorAsState(
            targetValue = when (isPressedState) {
                true -> MaterialTheme.colorScheme.onPrimary
                false -> MaterialTheme.colorScheme.onSurface
            }, label = ""
        )
        Button(
            onClick = {},
            modifier = modifier.scale(scale),
            interactionSource = interactionSource,
            colors = ButtonDefaults.buttonColors(containerColor, contentColor)
        ) {
            Text("Send Email")
        }
    }
@Composable
    override fun RegisterButton(modifier: Modifier, onClick: () -> Unit) {
        Text(
            text = buildAnnotatedString {
                append("Don't have an Account? ")
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp
                    )
                ) {
                    append("Create Now!")
                }
            }, modifier = Modifier
                .clickable { onClick() }, textAlign = TextAlign.End
        )
    }
}