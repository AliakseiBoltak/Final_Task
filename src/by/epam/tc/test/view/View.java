package by.epam.tc.test.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import by.epam.tc.test.bean.AuthenticationRequest;
import by.epam.tc.test.bean.AuthenticationResponse;
import by.epam.tc.test.bean.BlockUserRequest;
import by.epam.tc.test.bean.ChooseTestToPassRequest;
import by.epam.tc.test.bean.ChooseTestToPassResponse;
import by.epam.tc.test.bean.CreateAnswerRequest;
import by.epam.tc.test.bean.CreateQuestionRequest;
import by.epam.tc.test.bean.CreateTestRequest;
import by.epam.tc.test.bean.RegistrationRequest;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.bean.ShowAllQuestionsResponse;
import by.epam.tc.test.bean.ShowAllTestsResponse;
import by.epam.tc.test.bean.ShowAllUsersResponse;
import by.epam.tc.test.bean.ShowAnswersRequest;
import by.epam.tc.test.bean.ShowAnswersResponse;
import by.epam.tc.test.bean.UnBlockUserRequest;
import by.epam.tc.test.controller.Controller;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.entity.Answer;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.entity.Test;
import by.epam.tc.test.entity.User;
import by.epam.tc.test.utils.StringUtils;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class View {

	private static final Controller controller = new Controller();
	private static Scanner scanner = new Scanner(System.in);
	private static boolean exitFlag = true;
	private static int sessionId;
	private static User currentUser;

	public static void main(String[] args) throws Exception {


		String StartMenu = "--------1-LOGINATION\n" + "--------2-REGISTRATION\n" + "--------0-EXIT";

		String AdminMenu = "--------1-ADD_NEW_TEST\n" + "--------2-SHOW_ALL_TESTS\n" + "--------3-ADD_NEW_QUESTION\n"

				+ "--------4-SHOW_ALL_QUESTIONS\n" + "--------5-SHOW_ANSWERS_BY_USERS_ID\n"

				+ "--------6-SHOW_ALL_USERS\n" + "--------7-BLOCK_USER\n" + "--------8-UNBLOCK_USER\n"

				+ "--------0-EXIT";

		String UserMenu = "--------1-SHOW_ALL_TESTS\n" + "--------2-CHOOSE_TEST_TO_PASS\n" + "--------0-EXIT";

		System.out.println(StartMenu);

		while (exitFlag) {

			// System.out.println(StartMenu);

			String mainCommand = scanner.nextLine();

			switch (mainCommand) {

			// main command 1- AUTHENTICATION
			case "1":
				System.out.println("Logination: ");
				System.out.println("Enter your login: ");
				String authLogin = scanner.nextLine();
				System.out.println("Enter your password: ");
				String authPassword = scanner.nextLine();
				AuthenticationRequest authenticationRequest = new AuthenticationRequest();
				authenticationRequest.setLogin(authLogin);
				authenticationRequest.setPassword(authPassword);
				authenticationRequest.setCommandName("AUTHENTICATION");
				AuthenticationResponse authenticationResponse = (AuthenticationResponse) controller
						.doRequest(authenticationRequest);

				currentUser = authenticationResponse.getUser();

				if (!authenticationResponse.isErrorStatus() && currentUser.getRole() == 1) {
				
					sessionId = currentUser.getUsers_id();

					System.out.println("Hello, " + currentUser.getLogin() + "!");

					// local admin commands
					boolean enter = true;

					while (enter) {

						System.out.println(AdminMenu);

						String localCommand = scanner.nextLine();

						switch (localCommand) {

						// ADD NEW Test
						case "1":
							System.out.print("Enter subject: ");
							String message = new Scanner(System.in).nextLine();
							CreateTestRequest addTestRequest = new CreateTestRequest();
							addTestRequest.setCommandName("CREATE_TEST");
							addTestRequest.setSubject(message);
							Response addTestResponse = controller.doRequest(addTestRequest);
							if (addTestResponse.isErrorStatus() == false) {
								System.out.println(addTestResponse.getResultMessage());
							} else {
								System.out.println(addTestResponse.getErrorMessage());
							}
							break;

						// Show all tests
						case "2":
							Request showTestRequest = new Request();
							showTestRequest.setCommandName("SHOW_ALL_TESTS");
							ShowAllTestsResponse showTestResponse = (ShowAllTestsResponse) controller
									.doRequest(showTestRequest);
							if (showTestResponse.isErrorStatus() == true) {
								System.out.println(showTestResponse.getErrorMessage());
							} else {
								for (Test n : showTestResponse.getTests()) {
									System.out.println("id: " + n.getId() + " | " + "subject: " + n.getSubject());
								}
							}
							break;

						// Add new question
						case "3":

							System.out.println("Enter question: ");
							String question = scanner.nextLine();

							System.out.println("Enter options: ");
							String options = scanner.nextLine();

							System.out.println("Enter correct answer (number): ");

							String correct = (scanner.nextLine());

							System.out.println("Enter test_id: ");
							String id = (scanner.nextLine());

							if (StringUtils.isInteger(id) && StringUtils.isInteger(correct)) {

								CreateQuestionRequest createQuestionRequest = new CreateQuestionRequest();
								createQuestionRequest.setTest_id(Integer.valueOf(id));
								createQuestionRequest.setQuestion(question);
								createQuestionRequest.setOptions(options);
								createQuestionRequest.setCorrect_answer(Integer.valueOf(correct));

								createQuestionRequest.setCommandName("CREATE_QUESTION");

								Response createTestResponse = controller.doRequest(createQuestionRequest);

								if (createTestResponse.isErrorStatus() == false) {
									System.out.println(createTestResponse.getResultMessage());
								} else {
									System.out.println(createTestResponse.getErrorMessage());
								}
							} else {
								System.out.println("Incorrect id or answers");
							}
							break;

						// Show all questions
						case "4":
							Request showQuestionsRequest = new Request();

							showQuestionsRequest.setCommandName("SHOW_ALL_QUESTIONS");

							ShowAllQuestionsResponse showQuestionsResponse = (ShowAllQuestionsResponse) controller
									.doRequest(showQuestionsRequest);

							if (showQuestionsResponse.isErrorStatus() == true) {
								System.out.println(showQuestionsResponse.getErrorMessage());
							} else {
								for (Question n : ((ShowAllQuestionsResponse) showQuestionsResponse).getQuestions()) {
									System.out.println("id:" + n.getId() + " | " + " test_id: " + n.getTest_id() + " | "
											+ " question: " + n.getQuestion() + " | " + " options:  " + n.getOptions()
											+ " | " + " correct answer:  " + n.getCorrect_answer());
								}
							}
							break;

						// Show answers by Users Id
						case "5":
							ShowAnswersRequest showAnswersRequest = new ShowAnswersRequest();

							System.out.println("Enter users id:");

							String id_user = (scanner.nextLine());

							if (StringUtils.isInteger(id_user)) {

								showAnswersRequest.setUserId(Integer.valueOf(id_user));

								showAnswersRequest.setCommandName("SHOW_ANSWERS");

								ShowAnswersResponse showAnswersResponse = (ShowAnswersResponse) controller
										.doRequest(showAnswersRequest);

								if (showAnswersResponse.isErrorStatus() == true) {
									System.out.println(showAnswersResponse.getErrorMessage());
								} else {
									for (Answer n : ((ShowAnswersResponse) showAnswersResponse).getAnswers()) {
										System.out
												.println("test id: " + n.getTest_id() + " | " + "mark: " + n.getMark());
									}
								}
							} else {
								System.out.println("Incorrect id");
							}
							break;

						// Show all users
						case "6":
							Request showUsersRequest = new Request();

							showUsersRequest.setCommandName("SHOW_ALL_USERS");

							ShowAllUsersResponse showUsersResponse = (ShowAllUsersResponse) controller
									.doRequest(showUsersRequest);

							if (showUsersResponse.isErrorStatus() == true) {
								System.out.println(showUsersResponse.getErrorMessage());
							} else {
								for (User n : ((ShowAllUsersResponse) showUsersResponse).getUsers()) {
									System.out.println("id: " + n.getUsers_id() + " | " + "login: " + n.getLogin()
											+ " | " + "password: " + n.getPass() + " | " + "role: " + n.getRole()
											+ " | " + "block status: " + n.getBlock_status());
								}
							}

							break;

						// Block user
						case "7":
							BlockUserRequest blockUsersRequest = new BlockUserRequest();

							blockUsersRequest.setCommandName("BLOCK_USER");

							System.out.println("Enter users id:");

							String users_id = (scanner.nextLine());

							blockUsersRequest.setUserId(users_id);

							Response blockResponse = controller.doRequest(blockUsersRequest);

							if (blockResponse.isErrorStatus() == false) {
								System.out.println(blockResponse.getResultMessage());
							} else {
								System.out.println(blockResponse.getErrorMessage());
							}

							break;

						// UnBlock user
						case "8":

							UnBlockUserRequest unblockUsersRequest = new UnBlockUserRequest();

							unblockUsersRequest.setCommandName("UNBLOCK_USER");

							System.out.println("Enter users id:");

							String user_id = (scanner.nextLine());

							unblockUsersRequest.setUserId(user_id);

							Response unblockResponse = controller.doRequest(unblockUsersRequest);

							if (unblockResponse.isErrorStatus() == false) {
								System.out.println(unblockResponse.getResultMessage());
							} else {
								System.out.println(unblockResponse.getErrorMessage());
							}

							break;

						// exit
						case "0":
							System.out.println("Good bye!");
							enter = false;
							break;
						default:
							System.out.println("Command does not exits!");
							break;

						}

					}

					 break;

				} else if (!authenticationResponse.isErrorStatus() && currentUser.getRole() == 0
						&& !(currentUser.getBlock_status() == 1) ) {

					// local user commands
					boolean enterUser = true;
					System.out.println("Hello, " + currentUser.getLogin() + "!");

					while (enterUser) {

						System.out.println(UserMenu);

						String localUserCommand = scanner.nextLine();

						switch (localUserCommand) {

						// Show all tests
						case "1":
							Request showTestRequest = new Request();

							showTestRequest.setCommandName("SHOW_ALL_TESTS");

							ShowAllTestsResponse showTestResponse = (ShowAllTestsResponse) controller
									.doRequest(showTestRequest);

							if (showTestResponse.isErrorStatus() == true) {
								System.out.println(showTestResponse.getErrorMessage());
							} else {
								for (Test n : showTestResponse.getTests()) {
									System.out.println("id: " + n.getId() + " | " + "subject: " + n.getSubject());
								}
							}
							break;

						// choose test to pass
						case "2":

							System.out.println("Enter test id: ");

							String test_id = (scanner.nextLine());

							ChooseTestToPassRequest chooseTestRequest = new ChooseTestToPassRequest();

							chooseTestRequest.setCommandName("CHOOSE_TEST_TO_PASS");

							if (StringUtils.isInteger(test_id)) {
								chooseTestRequest.setTestId(Integer.valueOf(test_id));

								ChooseTestToPassResponse chooseTestResponse = (ChooseTestToPassResponse) controller
										.doRequest(chooseTestRequest);

								List<Integer> correctAnswers = new ArrayList<Integer>();

								if (chooseTestResponse.isErrorStatus() == true) {
									System.out.println(chooseTestResponse.getErrorMessage());
								} else {
									for (Question n : chooseTestResponse.getQuestions()) {
										System.out.println("id: " + n.getId() + " | " + "question : " + n.getQuestion()
												+ " | " + "options: " + n.getOptions());
										correctAnswers.add(n.getCorrect_answer());
									}
								}

								if (correctAnswers.size() > 0) {

									List<Integer> userAnswers = new ArrayList<Integer>();

									for (int i = 0; i < correctAnswers.size();) {

										int c = i + 1;

										System.out.println("enter answer on " + c + " question");

										String a = scanner.nextLine();

										if (StringUtils.isInteger(a)) {

											userAnswers.add(Integer.valueOf(a));

											i++;

										} else {
											System.out.println("incorrect number! enter  1 ,2 ,3 or 4 !");
										}
									}

									int counter = 0;

									for (int i = 0; i < correctAnswers.size(); i++) {
										if (correctAnswers.get(i) == userAnswers.get(i)) {
											counter++;
										}
									}

									int result = (int) (counter / correctAnswers.size() * 100);

									if (result >= 60) {

										System.out.println("Test passed");

										CreateAnswerRequest createAnswerRequest = new CreateAnswerRequest();

										createAnswerRequest.setTest_id(Integer.valueOf(test_id));
										// need to create session id by user
										createAnswerRequest.setUsers_id(sessionId);

										createAnswerRequest.setMark(result);

										createAnswerRequest.setCommandName("CREATE_ANSWER");

										Response createAnswerResponse = controller.doRequest(createAnswerRequest);

										if (createAnswerResponse.isErrorStatus() == false) {
											// System.out.println(createAnswerResponse.getResultMessage());
										} else {
											// System.out.println(createAnswerResponse.getErrorMessage());
										}

									} else {
										System.out.println("Test failed, try again");

										CreateAnswerRequest createAnswerRequest = new CreateAnswerRequest();

										createAnswerRequest.setTest_id(Integer.valueOf(test_id));

										createAnswerRequest.setUsers_id(2);

										createAnswerRequest.setMark(result);

										createAnswerRequest.setCommandName("CREATE_ANSWER");

										Response createAnswerResponse = controller.doRequest(createAnswerRequest);

										if (createAnswerResponse.isErrorStatus() == false) {
											// System.out.println(createAnswerResponse.getResultMessage());
										} else {
											// System.out.println(createAnswerResponse.getErrorMessage());
										}
									}
								} else {
									System.out.println("Test is empty");
								}
							} else {
								System.out.println("Incorrect test id");
							}
							break;

						case "0":
							System.out.println("Good bye!");
							enterUser = false;
							break;

						// default:
						// System.out.println("Command does not exits!");
						// break;

						}
					}
				} else if (currentUser != null) {

					if (currentUser.getBlock_status() == 1) {
						System.out.println("User is blocked");
					}
				} else {
					System.out.println("Incorrect login or pass!");
				}
				
				break;
				// main command 2 - REGISTRATION
			case "2":
				System.out.println("Registration: ");

				System.out.println("Enter your login: ");

				String regLogin = scanner.nextLine();

				System.out.println("Enter your password: ");

				String regPassword = scanner.nextLine();

				RegistrationRequest registrationRequest = new RegistrationRequest();

				registrationRequest.setCommandName("REGISTRATION");

				registrationRequest.setLogin(regLogin);

				registrationRequest.setPassword(regPassword);

				Response registrationResponse = controller.doRequest(registrationRequest);

				if (registrationResponse.isErrorStatus() == false) {
					System.out.println(registrationResponse.getResultMessage());
				} else {
					System.out.println(registrationResponse.getErrorMessage());
				}
				break;

			case "0":
				System.out.println("Good bye!");
				exitFlag = false;
				break;

			default:
				System.out.println("Command does not exits!");
				break;
			}
		}

	}
}
