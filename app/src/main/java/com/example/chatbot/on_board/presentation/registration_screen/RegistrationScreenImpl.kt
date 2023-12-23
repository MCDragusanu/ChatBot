package com.example.chatbot.on_board.presentation.registration_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WorkOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatbot.R
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.common.ui.util.SnackbarEvent
import com.example.chatbot.common.ui.util.TextFieldState
import com.example.chatbot.common.ui.util.UIState
import com.example.chatbot.on_board.presentation.login_screen.LoginScreenImpl
import com.google.mlkit.vision.text.Text
import kotlinx.coroutines.flow.StateFlow



object RegistrationScreenImpl:RegistrationScreen() {

    @Composable
    fun NormalTextComponent(value: String) {
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 40.dp),
            style = TextStyle(
                fontSize = 30.sp,
                fontStyle = FontStyle.Normal
            ),
            color = Color.White,
            textAlign = TextAlign.Center
        )

    }

    @Composable
    fun HeadingTextComponent(value: String) {
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(),
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
    override fun Main(
        viewModel: RegistrationScreenViewModel,
        onCompletedRegistration: (String) -> Unit
    ) {
        val snackbarHostState = SnackbarHostState()
        val currentEvent by viewModel.snackbarChannel.collectAsState(null)

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.black_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            )
            Headline()

            // Partea de Register
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)

            )
            {
                // Middle Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(), // Seteaza inaltimea pentru a se adapta continutului
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),

                ){
                    Column(
                        modifier = Modifier
                            .padding(16.dp)

                    ) {
                        // Email Text Field
                        EmailTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            state = viewModel.emailFieldState,
                            onValueChanged = viewModel::onEmailChanged
                        )

                        // Password Text Field
                        PasswordTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            state = viewModel.passwordFieldState,
                            onValueChanged = viewModel::onPasswordChanged
                        )

                        // First Name and Last Name Text Fields
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            FirstNameTextField(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp),
                                state = viewModel.firstNameFieldState,
                                onValueChanged = viewModel::onFirstNameChanged
                            )

                            LastNameTextField(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 8.dp),
                                state = viewModel.lastNameFieldState,
                                onValueChanged = viewModel::onLastNameChanged
                            )
                        }

                        // Occupation Text Field
                        OccupationTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            state = viewModel.occupationFieldState,
                            onValueChanged = viewModel::onOccupationChanged
                        )

                        // Register Button
                        RegisterButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            onClick = { /* Handle button click */ }
                        )
                    }
                }
            }
        }
    }

    // ...

    @Composable
    override fun Headline() {
        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.registration),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
            Text(
                text = stringResource(id = R.string.create_account),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.registrationscreen),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
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
                textStyle = Typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground),
                value = currentState.content,
                onValueChange = onValueChanged,
                modifier = Modifier.fillMaxWidth().width(20.dp),
                isError = currentState.state.isError(),
                enabled = !currentState.state.isLoading(),
                label = { Text("Email") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.blue),
                    unfocusedBorderColor = colorResource(id = R.color.blue),
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = null) },
                trailingIcon = {
                    AnimatedVisibility(currentState.state.isCompleted()) {
                        //Animates and displays what's inside the block when the boolean is true
                        //Show a checkmark when the email is correct
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
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

    fun onPasswordVisibilityToggle(passwordVisibilityState: MutableState<Boolean>) {
        passwordVisibilityState.value = !passwordVisibilityState.value
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
                textStyle = Typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground),
                value = currentState.content,
                onValueChange = onValueChanged,
                modifier = Modifier.fillMaxWidth().width(20.dp),
                isError = currentState.state.isError(),
                enabled = !currentState.state.isLoading(),
                visualTransformation = if (passwordIsHidden) VisualTransformation.None else PasswordVisualTransformation(),  // to show ****** when is hidden else tghe content
                label = { Text("Password") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.blue),
                    unfocusedBorderColor = colorResource(id = R.color.blue),
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null,) },
                trailingIcon = {
                    AnimatedVisibility(passwordIsHidden && !currentState.state.isCompleted()) {
                        //Animates and displays what's inside the block when the boolean is true
                        Icon(
                            Icons.Filled.Visibility,
                            contentDescription = null,
                            modifier = Modifier.clickable { passwordIsHidden = false })
                    }
                    AnimatedVisibility(!passwordIsHidden) {
                        Icon(
                            Icons.Filled.VisibilityOff,
                            contentDescription = null,
                            modifier = Modifier.clickable { passwordIsHidden = true })
                    }
                    AnimatedVisibility(currentState.state.isCompleted()) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
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
    override fun FirstNameTextField(
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
                textStyle = Typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground),
                value = currentState.content,
                onValueChange = onValueChanged,
                modifier = Modifier.fillMaxWidth(),
                isError = currentState.state.isError(),
                enabled = !currentState.state.isLoading(),
                label = { Text("First Name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.blue),
                    unfocusedBorderColor = colorResource(id = R.color.blue)
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
                trailingIcon = {
                    AnimatedVisibility(currentState.state.isCompleted()) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    AnimatedVisibility(currentState.state.isError()) {
                        Icon(Icons.Filled.Warning, contentDescription = null)
                    }
                }
            )
            AnimatedVisibility(currentState.errorCode != null) {
                currentState.errorCode?.let {
                    Text(stringResource(it), color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun LastNameTextField(
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
                textStyle = Typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground),
                value = currentState.content,
                onValueChange = onValueChanged,
                modifier = Modifier.fillMaxWidth(),
                isError = currentState.state.isError(),
                enabled = !currentState.state.isLoading(),
                label = { Text("Last Name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.blue),
                    unfocusedBorderColor = colorResource(id = R.color.blue)
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
                trailingIcon = {
                    AnimatedVisibility(currentState.state.isCompleted()) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    AnimatedVisibility(currentState.state.isError()) {
                        Icon(Icons.Filled.Warning, contentDescription = null)
                    }
                }
            )
            AnimatedVisibility(currentState.errorCode != null) {
                currentState.errorCode?.let {
                    Text(stringResource(it), color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun OccupationTextField(
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
                textStyle = Typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground),
                value = currentState.content,
                onValueChange = onValueChanged,
                modifier = Modifier.fillMaxWidth(),
                isError = currentState.state.isError(),
                enabled = !currentState.state.isLoading(),
                label = { Text("Occupation") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.blue),
                    unfocusedBorderColor = colorResource(id = R.color.blue)
                ),
                leadingIcon = { Icon(imageVector = Icons.Filled.WorkOutline, contentDescription = null) },
                trailingIcon = {
                    AnimatedVisibility(currentState.state.isCompleted()) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    AnimatedVisibility(currentState.state.isError()) {
                        Icon(Icons.Filled.Warning, contentDescription = null)
                    }
                }
            )
            AnimatedVisibility(currentState.errorCode != null) {
                currentState.errorCode?.let {
                    Text(stringResource(it), color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }





    @Composable
    override fun TermsOfUseCheckBox(
        modifier: Modifier,
        state: StateFlow<Boolean>,
        onStateChanged: (Boolean) -> Unit
    ) {
        val isChecked by state.collectAsState()

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { newCheckedState ->
                    onStateChanged(newCheckedState)
                },
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = "I agree to the Terms of Use",
                modifier = Modifier.clickable { onStateChanged(!isChecked) },
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }

    @Composable
    override fun TermsOfUseDialog(
        onDismiss: () -> Unit,
        onRejected: () -> Unit,
        onAccepted: () -> Unit
    ) {

        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.terms_of_use),
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(onClick = { onDismiss() }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            },
            text = {
                Column {

                    Text(
                        text = stringResource(id = R.string.terms_of_use_content),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onAccepted()
                        onDismiss()
                    }
                ) {
                    Text(stringResource(id = R.string.accept))
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onRejected()
                        onDismiss()
                    }
                ) {
                    Text(stringResource(id = R.string.reject))
                }
            },

            modifier = Modifier.padding(16.dp)
        )
    }

    @Composable
    override fun RegisterButton(modifier: Modifier, onClick: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.button_image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp) // Set the size as per your requirement
                    .clip(CircleShape) // You can use other shapes or remove the clip
            )

            Button(
                onClick = onClick,
                modifier = modifier // Added modifier parameter to the Button
            ) {
                Text(text = "Create My Account")
            }
        }
    }


}







